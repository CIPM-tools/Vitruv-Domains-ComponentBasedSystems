/*
 * generated by Xtext 2.12.0
 */
package tools.vitruv.dsls.commonalities

import com.google.inject.Injector
import tools.vitruv.dsls.reactions.ReactionsLanguageStandaloneSetup

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class CommonalitiesLanguageStandaloneSetup extends CommonalitiesLanguageStandaloneSetupGenerated {

	override Injector createInjectorAndDoEMFRegistration() {
		// Set up Reactions Language dependency:
		ReactionsLanguageStandaloneSetup.doSetup()
		return super.createInjectorAndDoEMFRegistration()
	}

	static def void doSetup() {
		new CommonalitiesLanguageStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
