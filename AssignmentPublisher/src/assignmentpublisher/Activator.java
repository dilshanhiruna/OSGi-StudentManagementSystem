package assignmentpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Assignment Publisher start");
		AssignmentService assignmentservicepublisher = new AssignmentServiceImpl();
		
		publishServiceRegistration = context.registerService(AssignmentService.class.getName(), assignmentservicepublisher, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Assignment publisher stop");
		publishServiceRegistration.unregister();
		
	}

}
