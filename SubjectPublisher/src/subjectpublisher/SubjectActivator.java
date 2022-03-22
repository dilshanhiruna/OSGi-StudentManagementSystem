package subjectpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class SubjectActivator implements BundleActivator {

private ServiceRegistration serviceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Subject Publisher started");
		SubjectPublish subjectService = new SubjectPublishImpl();
		serviceRegistration = bundleContext.registerService(SubjectPublish.class.getName(), subjectService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Subject Publisher stopped");
		serviceRegistration.unregister();
	}

}
