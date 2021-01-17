package tools.vitruv.testutils.domains;

import pcm_mockup.Pcm_mockupPackage;
import tools.vitruv.framework.domains.AbstractTuidAwareVitruvDomain;
import tools.vitruv.framework.tuid.AttributeTuidCalculatorAndResolver;

public final class PcmMockupDomain extends AbstractTuidAwareVitruvDomain {
	public static final String METAMODEL_NAME = "PcmMockup";
	public static final String FILE_EXTENSION = "pcm_mockup";
	
	PcmMockupDomain() {
		super(METAMODEL_NAME, Pcm_mockupPackage.eINSTANCE, 
				new AttributeTuidCalculatorAndResolver(Pcm_mockupPackage.eNS_URI, Pcm_mockupPackage.Literals.IDENTIFIED__ID.getName()), 
				FILE_EXTENSION);
	}

	@Override
	public boolean isUserVisible() {
		return false;
	}
	
}
