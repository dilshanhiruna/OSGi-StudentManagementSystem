package gradeconsumer;

import gradepublisher.GradeService;
import gradepublisher.GradeServiceImpl;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("=======================================================================");
		System.out.println("Start gradeconsumer service");

		serviceReference = context.getServiceReference(GradeService.class.getName());
			
		GradeService gradeservice = (GradeService) context.getService(serviceReference);
		menu(gradeservice);
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		System.out.println("Stop the gradeconsumer service");
		System.out.println("=======================================================================");
		context.ungetService(serviceReference);
		
	}
	
	public void menu(GradeService gradeService) {
		int input;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n************Student Management System v1.0************\n");
		
		System.out.println("1) Insert Grade ");
		System.out.println("2) Update Grade ");
		System.out.println("3) Delete Grade ");
		System.out.println("4) List the Grade");
		
		System.out.print("\nEnter the number : ");
		input = Integer.parseInt(sc.nextLine().trim());
		System.out.println("");
		
		if(input == 1) {
			gradeService.insertGrades();
			menu(gradeService);
		}else if(input == 2) {
			gradeService.updateGrades();
			menu(gradeService);
		}else if(input == 3) {
			gradeService.deleteGrades();
			menu(gradeService);
		}else if(input == 4) {
			gradeService.listGrades();
			menu(gradeService);
		}else {
			System.out.println("Invalid Input...");
			menu(gradeService);
		}
	}

}
