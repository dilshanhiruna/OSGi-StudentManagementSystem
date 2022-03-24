package assignmentconsumer;

import assignmentpublisher.AssignmentService;
import gradepublisher.GradeService;
import subjectpublisher.SubjectPublish;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


public class Activator implements BundleActivator {

	ServiceReference serviceReferenceGrade;
	ServiceReference serviceReferenceAssignment;
	ServiceReference serviceReferenceSubject;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("=======================================================================");
		System.out.println("Start assignmentconsumer service");

		serviceReferenceAssignment = context.getServiceReference(AssignmentService.class.getName());		
		AssignmentService assignmentservice = (AssignmentService) context.getService(serviceReferenceAssignment);
		
		serviceReferenceGrade = context.getServiceReference(GradeService.class.getName());		
		GradeService gradeservice = (GradeService) context.getService(serviceReferenceGrade);
		
		serviceReferenceSubject = context.getServiceReference(SubjectPublish.class.getName());		
		SubjectPublish subjectservice = (SubjectPublish) context.getService(serviceReferenceSubject);
				
		menu(assignmentservice,gradeservice,subjectservice);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {

		System.out.println("Stop the assignmentconsumer service");
		System.out.println("=======================================================================");
		context.ungetService(serviceReferenceAssignment);
		context.ungetService(serviceReferenceGrade);
		context.ungetService(serviceReferenceSubject);
		
	}
	
	public void menu(AssignmentService assignmentservice,GradeService gradeService, SubjectPublish subjectservice) {
		int input;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n************Student Management System v1.0************\n");
		
		System.out.println("1) Add assignment ");
		System.out.println("2) Update assignment ");
		System.out.println("3) Delete assignment ");
		System.out.println("4) View assignment");
		System.out.println("5) Exit");
		
		System.out.print("\nEnter the number : ");
		input = Integer.parseInt(sc.nextLine().trim());
		System.out.println("");
		
		if(input == 1) {
			
			System.out.println("Please Select a grade index:");
			String selectedGrade = gradeService.getGrade();
			
			System.out.println("Grade : "+selectedGrade);
			
			System.out.println("Please Select the subject index:");
			String selectedSubject = subjectservice.getSubjectsOfGrade(selectedGrade);
			
			System.out.println("Subject : "+selectedSubject);
			if(selectedSubject == "nothing") {
				assignmentservice.exit();
			}else {
			assignmentservice.addAssigments(selectedGrade,selectedSubject);
			menu(assignmentservice,gradeService,subjectservice);
			}
		}else if(input == 2) {
			System.out.println("Please Select a grade index:");
			String selectedGrade = gradeService.getGrade();
			
			System.out.println("Grade : "+selectedGrade);
			
			System.out.println("Please Select the subject index:");
			String selectedSubject = subjectservice.getSubjectsOfGrade(selectedGrade);
			
			System.out.println("Subject : "+selectedSubject);
			
			if(selectedSubject == "nothing") {
				assignmentservice.exit();
			}else {
				assignmentservice.updateAssignmentOfGrades(selectedGrade,selectedSubject);
				menu(assignmentservice,gradeService,subjectservice);
			}
			
			
		}else if(input == 3) {
			System.out.println("Please Select a grade index:");
			String selectedGrade = gradeService.getGrade();
			
			System.out.println("Grade : "+selectedGrade);
			
			System.out.println("Please Select the subject index:");
			String selectedSubject = subjectservice.getSubjectsOfGrade(selectedGrade);
			
			if(selectedSubject == "nothing") {
				assignmentservice.exit();
			}else {
				assignmentservice.removeAssignmentofGrades(selectedGrade,selectedSubject);
				menu(assignmentservice,gradeService,subjectservice);
			}
			
			
			
		}else if(input == 4) {
			System.out.println("Please Select a grade index:");
			String selectedGrade = gradeService.getGrade();
			
			System.out.println("Grade : "+selectedGrade);
			
			System.out.println("Please Select the subject index:");
			String selectedSubject = subjectservice.getSubjectsOfGrade(selectedGrade);
			
			if(selectedSubject == "nothing") {
				assignmentservice.exit();
			}else {
				assignmentservice.viewAssignmentOfGrade(selectedGrade,selectedSubject);
				menu(assignmentservice,gradeService,subjectservice);
			}
			
			
		}else if(input == 5) {
			assignmentservice.exit();
		}else {
			System.out.println("Invalid Input...");
			menu(assignmentservice,gradeService,subjectservice);

		}
	}
}
