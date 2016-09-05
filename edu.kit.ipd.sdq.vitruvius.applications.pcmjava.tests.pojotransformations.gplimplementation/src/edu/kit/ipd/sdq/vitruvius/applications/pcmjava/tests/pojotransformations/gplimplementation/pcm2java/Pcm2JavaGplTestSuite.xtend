package edu.kit.ipd.sdq.vitruvius.applications.pcmjava.tests.pojotransformations.gplimplementation.pcm2java

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses
import edu.kit.ipd.sdq.vitruvius.applications.pcmjava.tests.pojotransformations.gplimplementation.pcm2java.repository.Pcm2JavaRepositoryGplTestSuite
import edu.kit.ipd.sdq.vitruvius.applications.pcmjava.tests.pojotransformations.gplimplementation.pcm2java.system.Pcm2JavaSystemGplTestSuite

@RunWith(Suite)
@SuiteClasses(#[
	Pcm2JavaRepositoryGplTestSuite,
	Pcm2JavaSystemGplTestSuite
])
class Pcm2JavaGplTestSuite {
	
}
