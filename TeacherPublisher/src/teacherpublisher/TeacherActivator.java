package teacherpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class TeacherActivator implements BundleActivator {

	private ServiceRegistration serviceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Teacher Publisher started");
		TeacherPublish teacherService = new TeacherPublishImpl();
		serviceRegistration = bundleContext.registerService(TeacherPublish.class.getName(), teacherService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Teacher Publisher stopped");
		serviceRegistration.unregister();
	}

}
