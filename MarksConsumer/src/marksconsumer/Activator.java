package marksconsumer;

import java.util.Scanner;

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
		MarksService marksUI = (MarksService)context.getService(serviceReference);	
		menu(marksUI);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Marks Consumer Stops");
		context.ungetService(serviceReference);
	}
	
	public void menu(MarksService service) {
		
		System.out.print("WOOOOOH!!! IT WORKS");
		
	}

}
