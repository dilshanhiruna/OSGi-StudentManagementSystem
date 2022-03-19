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
		
		if(serviceReference != null) {
			@SuppressWarnings("unchecked")
			MarksService marksService = (MarksService)context.getService(serviceReference);
			menu(marksService);
		} else {
			System.err.println("service reference not found.");
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Marks Consumer Stops");
		context.ungetService(serviceReference);
	}
	
	public void menu(MarksService marksService) {
		
		int input;

		Scanner sc = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("Student Management System v1.0");
		System.out.println("1) Enter Marks ");
		System.out.println("2) Update Marks");
		System.out.println("3) Delete Marks");
		System.out.println("4) Get Marks");
		input = Integer.parseInt(sc.nextLine().trim());
		System.out.println("\n");
		if(input == 1) {
			System.out.println("Enter Marks ------------------");
			System.out.println("1) Enter Marks ");
			System.out.println("2) Update Marks");
			System.out.println("3) Delete Marks");
			System.out.println("4) Get Marks");
			
		}
		
	}

}
