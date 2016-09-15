package tools.vitruv.applications.jmljava.tests.plugintests;

import static org.junit.Assert.assertNotNull;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import tools.vitruv.domains.jml.language.jML.JMLFactory;
import tools.vitruv.domains.jml.language.jML.JMLMemberModifier;
import tools.vitruv.domains.jml.language.jML.JMLSpecMemberModifier;
import tools.vitruv.domains.jml.language.jML.MemberDeclWithModifier;
import tools.vitruv.domains.jml.language.jML.MethodDeclaration;
import tools.vitruv.applications.jmljava.changesynchronizer.ChangeSynchronizerRegistry;
import tools.vitruv.applications.jmljava.changesynchronizer.ModelUtilities;
import tools.vitruv.applications.jmljava.changesynchronizer.ChangeBuilder;
import tools.vitruv.framework.change.description.ConcreteChange;

public abstract class JMLModifierTestBase extends FrameworkTestBase {

	protected abstract JMLSpecMemberModifier getJMLModifier();
	
	protected void performTest(final String fileName, final String typeName, final String methodName, boolean add, boolean abortExpected) throws Exception {
		MethodDeclaration md = projectModelUtils.getMethod(fileName, typeName, methodName);
		assertNotNull(md);
		MemberDeclWithModifier memberDecl = ModelUtilities.getParentOfType(md, MemberDeclWithModifier.class);
		assertNotNull(memberDecl);
		
		MemberDeclWithModifier memberDeclOld = ModelUtilities.clone(memberDecl);
		MemberDeclWithModifier memberDeclChanged = ModelUtilities.clone(memberDecl);
		
		ConcreteChange change = null;
		if (add) {
			JMLMemberModifier modifier = JMLFactory.eINSTANCE.createJMLMemberModifier();
			modifier.setModifier(getJMLModifier());
			memberDeclChanged.getJmlModifiers().add(modifier);
			change = ChangeBuilder.createCreateChange(modifier, memberDeclOld);
		} else {
			Predicate<JMLMemberModifier> findModifier = new Predicate<JMLMemberModifier>() {
				@Override
				public boolean apply(JMLMemberModifier input) {
					return input.getModifier() == getJMLModifier();
				}
			};
			
			Optional<JMLMemberModifier> modifier = Iterables.tryFind(memberDeclChanged.getJmlModifiers(), findModifier);
			memberDeclChanged.getJmlModifiers().remove(modifier.get());
			Optional<JMLMemberModifier> modifierOld = Iterables.tryFind(memberDeclOld.getJmlModifiers(), findModifier);
			change = ChangeBuilder.createDeleteChange(modifierOld.get(), memberDeclChanged);
		}
		
        ChangeSynchronizerRegistry.getInstance().getChangeSynchronizer().synchronizeChange(change);
        
        waitForSynchronisationToFinish();
        
        if (abortExpected) {
        	assertTransformationAborted();
        } else {
        	final String testMethodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        	createAndCompareDiff(testMethodName);
        }
	}
	
}
