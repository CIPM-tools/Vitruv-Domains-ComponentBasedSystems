package edu.kit.ipd.sdq.vitruvius.casestudies.jml.run.monitorededitor.changeinjection;

import javax.swing.JOptionPane;

import edu.kit.ipd.sdq.vitruvius.framework.change.description.VitruviusChange;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.CompilationUnit;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.FieldDeclaration;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.IdentifierHaving;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.JMLPackage;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.MemberDecl;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.MemberDeclWithModifier;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.MemberDeclaration;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.MethodDeclaration;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.jML.VariableDeclarator;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.run.monitorededitor.ChangeBuilder;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.run.monitorededitor.ModelUtilities;

/**
 * Base class for rename operations on member elements in JML.
 */
public abstract class JMLInjectRenameMemberBase extends JMLInjectionHandler {

    /**
     * Determines the member, which shall be renamed.
     * 
     * @param cu
     *            The root object of the model.
     * @return The member to be renamed.
     */
    protected abstract MemberDeclWithModifier getMemberToRename(CompilationUnit cu);

    @Override
    protected boolean performChangeOn(CompilationUnit cu) {
        MemberDeclWithModifier member = getMemberToRename(cu);
        if (member == null) {
            return false;
        }

        MemberDecl memberDecl = member.getMemberdecl();
        if (!(memberDecl instanceof MemberDeclaration)) {
            return false;
        }

        MemberDeclaration memberDeclaration = (MemberDeclaration) memberDecl;

        String newName = JOptionPane.showInputDialog("Enter a new name:");

        if (memberDeclaration.getMethod() != null) {
            return rename(memberDeclaration.getMethod(), newName);
        } else if (memberDeclaration.getField() != null) {
            return rename(memberDeclaration.getField(), newName);
        }

        return false;
    }

    /**
     * Performs the rename operation for a method.
     * 
     * @param methodDeclaration
     *            The method to be renamed.
     * @param newName
     *            The new name.
     * @return True if the rename change has been successfully submitted.
     */
    private boolean rename(MethodDeclaration methodDeclaration, String newName) {
        return rename((IdentifierHaving) methodDeclaration, newName);
    }

    /**
     * Performs the rename operation for a field.
     * 
     * @param fieldDeclaration
     *            The field to be renamed.
     * @param newName
     *            The new name.
     * @return True if the rename change has been successfully submitted.
     */
    private boolean rename(FieldDeclaration fieldDeclaration, String newName) {
        VariableDeclarator firstVarDecl = fieldDeclaration.getVariabledeclarator().get(0);
        return rename((IdentifierHaving) firstVarDecl, newName);
    }

    /**
     * Performs the rename operation for an element with identifier.
     * 
     * @param element
     *            The element to be renamed.
     * @param newName
     *            The new name.
     * @return True if the rename change has been successfully submitted.
     */
    private boolean rename(IdentifierHaving element, String newName) {
        if (newName == null) {
            return false;
        }

        IdentifierHaving oldElement = ModelUtilities.clone(element);
        IdentifierHaving newElement = ModelUtilities.clone(element);
        newElement.setIdentifier(newName);
        
        VitruviusChange change = ChangeBuilder.createUpdateChange(oldElement, newElement,
                JMLPackage.eINSTANCE.getIdentifierHaving_Identifier());
        submitChange(change);

        return true;
    }

}
