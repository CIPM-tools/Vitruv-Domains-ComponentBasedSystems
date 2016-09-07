package tools.vitruv.applications.jmljava.tests.plugintests;

import org.junit.Test;

import tools.vitruv.domains.jml.language.jML.JMLSpecMemberModifier;

public class AddHelperTest extends JMLModifierTestBase {

	@Test
	public void testBasic() throws Exception {
		performTest("APDU.jml", "APDU", "getInBlockSize", false);
	}
	
	private void performTest(final String fileName, final String typeName, final String methodName, boolean abortExpected) throws Exception {
		performTest(fileName, typeName, methodName, true, abortExpected);
	}
	
	@Override
	protected JMLSpecMemberModifier getJMLModifier() {
		return JMLSpecMemberModifier.HELPER;
	}
	
}
