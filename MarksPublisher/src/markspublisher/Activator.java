package markspublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private ServiceRegistration serviceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Marks Publisher started");
		MarksServiceImpl marksInterface = new MarksServiceImpl();
		serviceRegistration = bundleContext.registerService(MarksServiceImpl.class.getName(), marksInterface, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Marks Publisher stopped");
		serviceRegistration.unregister();
	}

}
