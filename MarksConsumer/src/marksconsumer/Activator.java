package marksconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import markspublisher.MarksService;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Marks Consumer Starts");
		serviceReference = context.getServiceReference(MarksService.class.getName());
		@SuppressWarnings("unchecked")
		MarksService marksService = (MarksService)context.getService(serviceReference);	
		menu(marksService);

	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Marks Consumer Stops");
		context.ungetService(serviceReference);
	}
	
	public void menu(MarksService marksService) {
		
		marksService.insertMarks(911, 444);
		
	}

}
