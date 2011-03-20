
package ch.miranet.dsl.site;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SiteDslStandaloneSetup extends SiteDslStandaloneSetupGenerated{

	public static void doSetup() {
		new SiteDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

