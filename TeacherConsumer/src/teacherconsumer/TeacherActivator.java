package teacherconsumer;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import gradepublisher.GradeService;
import subjectpublisher.Subject;
import subjectpublisher.SubjectPublish;
import teacherpublisher.TeacherPublish;

public class TeacherActivator implements BundleActivator {
	
	ServiceReference serviceReferenceTeacher;
	TeacherPublish teacherPublish;
	
	public void start(BundleContext bundleContext) throws Exception {
		serviceReferenceTeacher = bundleContext.getServiceReference(TeacherPublish.class.getName());
		teacherPublish = (TeacherPublish) bundleContext.getService(serviceReferenceTeacher);
		loopService();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Teacher service consumer stopeed!");
		bundleContext.ungetService(serviceReferenceTeacher);
	}
	
	//method to loop service(get and direct user for a service)
	public void loopService() {
		int selectedService = selectService();
		directToService(selectedService);
	}
	
	//method to display and get selected service from the user
	public int selectService() {
		
		System.out.println("");
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Welcome to teacher service!");
		System.out.println("---------------------------");
		
		System.out.println("");
		System.out.println("Here are the services available to you: ");
		System.out.println("------------------------------------------------------");
		System.out.println("Press 1 to Add new teacher");
		System.out.println("Press 2 to View all teachers");
		System.out.println("Press 3 to Delete teachers");
		System.out.println("------------------------------------------------------");


		System.out.println("");
		System.out.print("Please select the service you wish to continue: ");
		System.out.println("");



		
		Scanner scan = new Scanner(System.in);
		int input  = scan.nextInt();
		
		return input;
	}
	
	//method to direct user to the selected service
	public void directToService(int selectedService) {
		if(selectedService==1) {
			System.out.println("---------------------");
			teacherPublish.addNewTeacher();
		}
		else if(selectedService==2) {
			System.out.println("");
			teacherPublish.viewAllTeachers();
		}
		else if(selectedService==3) {
			System.out.println("");
			teacherPublish.deleteTeacher();
		}
		else if(selectedService==0) {
			System.out.println("-----------------------------");
			System.out.println("Thank you... Have a nice day!");
			System.out.println("-----------------------------");

		}
		else {
			System.out.println("Please enter a valid service number");
		}
		loopService();
	}

}

