package subjectconsumer;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import gradepublisher.GradeService;
import subjectpublisher.SubjectPublish;

public class SubjectActivator implements BundleActivator {

	ServiceReference serviceReferenceSubject;
	ServiceReference serviceReferenceGrade;
	SubjectPublish subjectPublish;
	GradeService gradeService;


	public void start(BundleContext bundleContext) throws Exception {
		serviceReferenceSubject = bundleContext.getServiceReference(SubjectPublish.class.getName());
		subjectPublish = (SubjectPublish) bundleContext.getService(serviceReferenceSubject);
		
		serviceReferenceGrade = bundleContext.getServiceReference(GradeService.class.getName());
		gradeService = (GradeService) bundleContext.getService(serviceReferenceGrade);
		
		//get and direct user for a service
		loopService();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("bye");
		bundleContext.ungetService(serviceReferenceSubject);
		bundleContext.ungetService(serviceReferenceGrade);

	}
	
	//method to loop service
	public void loopService() {
		//display and get selected service
		int selectedService = selectService();
				
		//direct to service
		directToService(selectedService);
	}
	
	//method to display and get selected service from the user
	public int selectService() {
		
		System.out.println("");
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Welcome to student service!");
		System.out.println("---------------------------");
		
		System.out.println("");
		System.out.println("Here are the services available to you: ");
		System.out.println("");

		System.out.println("------------------------------------------------------");
		System.out.println("Press 1 to Add new subject");
		System.out.println("Press 2 to View all the subjects of the school");
		System.out.println("Press 3 to View all the subjects of a perticular grade");
		System.out.println("Press 4 to Edit subject details");
		System.out.println("Press 5 to Detele subjects");
		System.out.println("------------------------------------------------------");


		System.out.println("");
		System.out.print("Please select the service you wish to continue: ");


		
		Scanner scan = new Scanner(System.in);
		int input  = scan.nextInt();
		
		return input;
	}
	
	public void directToService(int selectedService) {
		if(selectedService==1) {
			System.out.println("Please Select a grade:");
			
			//store the grade
			String selectedGrade = gradeService.getGrade();
			
			System.out.println("---------------------");
			subjectPublish.addSubjects(selectedGrade);
		}
		else if(selectedService==2) {
			subjectPublish.viewAllSubjects();
		}
		else if(selectedService==3) {
			System.out.println("Please Select a grade:");
			
			//store the grade
			String selectedGrade = gradeService.getGrade();
			
			System.out.println("---------------------");
			subjectPublish.viewSubjectsOfGrade(selectedGrade);;
		}
		else if(selectedService==4) {
			subjectPublish.editSubjects();
		}
		else if(selectedService==5) {
			subjectPublish.deleteSubjects();
		}
		else {
			System.out.println("Please enter a valid service number");
		}
		//get and direct user for a service
		loopService();
	}

}

