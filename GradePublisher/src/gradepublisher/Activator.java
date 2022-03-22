package gradepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Grade Publisher start");
		GradeService gradeservicepublisher = new GradeServiceImpl();
		
		publishServiceRegistration = context.registerService(GradeService.class.getName(), gradeservicepublisher, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Grade publisher stop");
		publishServiceRegistration.unregister();
		
	}
	

}
