package tools.vitruv.applications.jmljava.tests.plugintests;

import org.junit.Test;

import tools.vitruv.domains.jml.language.jML.JMLSpecMemberModifier;

public class RemovePureTest extends JMLModifierTestBase {

	@Test
	public void testBasic() throws Exception {
		performTest("APDU.jml", "APDU", "getInBlockSize", false);
	}
	
	@Test
	public void testConflict() throws Exception {
		performTest("APDU.jml", "APDU", "getProtocol", true);
	}
	
	private void performTest(final String fileName, final String typeName, final String methodName, boolean abortExpected) throws Exception {
		performTest(fileName, typeName, methodName, false, abortExpected);
	}

	@Override
	protected JMLSpecMemberModifier getJMLModifier() {
		return JMLSpecMemberModifier.PURE;
	}
	
}
