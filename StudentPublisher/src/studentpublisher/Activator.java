package studentpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import studentpublisher.StudentsService;
import studentpublisher.StudentsServiceImpl;

public class Activator implements BundleActivator {

	private ServiceRegistration serviceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Student Publisher Started");
		StudentsService studentsInterface = new StudentsServiceImpl();
		serviceRegistration = bundleContext.registerService(StudentsService.class.getName(), studentsInterface, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Students Publisher stopped");
		serviceRegistration.unregister();
	}

}
