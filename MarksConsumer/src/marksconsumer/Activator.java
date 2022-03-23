package marksconsumer;


import gradepublisher.GradeService;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import stup.StudentInterface;
import markspublisher.MarksService;
import subjectpublisher.SubjectPublish;

public class Activator implements BundleActivator {

	ServiceReference sr1,sr2,sr3,sr4;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Marks Consumer Starts");
		sr1 = context.getServiceReference(MarksService.class.getName());
		sr2 = context.getServiceReference(GradeService.class.getName());
		sr3 = context.getServiceReference(StudentInterface.class.getName());
		sr4 = context.getServiceReference(SubjectPublish.class.getName());
		
		if(sr1 != null  || sr2 != null || sr3 != null || sr4 != null ) {
			@SuppressWarnings("unchecked")
			MarksService marksService = (MarksService)context.getService(sr1);
			@SuppressWarnings("unchecked")
			GradeService gradeService = (GradeService) context.getService(sr2);
			@SuppressWarnings("unchecked")
			StudentInterface studentService = (StudentInterface) context.getService(sr3);
			@SuppressWarnings("unchecked")
			SubjectPublish subjectService = (SubjectPublish) context.getService(sr4);
			
			menu(marksService,gradeService,studentService,subjectService);
			
		} else {
			System.err.println("service reference not found.");
		}
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Marks Consumer Stops");
		context.ungetService(sr1);
		context.ungetService(sr2);
		context.ungetService(sr3);
		context.ungetService(sr4);
	}
	
	public void menu(MarksService marksService,GradeService gradeService,StudentInterface studentService,SubjectPublish subjectService) {
		
		int input;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n");
		System.out.println("-----Student Management System v1.0-----");
		System.out.println("1) Enter Marks ");
		System.out.println("2) Update Marks");
		System.out.println("3) Delete Marks");
		System.out.println("4) Get Marks");
		System.out.println("5) Get Higest Marks");
		System.out.println("6) Get Average Marks");
		System.out.println("7) Exit");
		
		System.out.println("Enter (1/2/3/4/5/6/7): ");
		input = Integer.parseInt(sc.next().trim());
		System.out.println("\n");
		
		if(input == 1) {
			
			System.out.println("---------------------");
			
			System.out.println("Please Select a grade:");
			
			//store the grade
			String selectedGrade = gradeService.getGrade();
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[STUDENT: ] [SUBJECT: ]\n");
			
			System.out.println("Please Select a student:");
			
			//store the student
			String selectedStudent= studentService.getStudents(selectedGrade);
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[STUDENT: "+selectedStudent+"] "+"[SUBJECT: ]\n");
			
			System.out.println("Please Select a subject;");
			
			//store the subject
			String selectedSubject= subjectService.getSubjectsOfGrade(selectedGrade);
			
			if(selectedSubject.equals("nothing")) {
				menu(marksService,gradeService,studentService,subjectService);
			}
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[STUDENT: "+selectedStudent+"]"+" [SUBJECT: "+selectedSubject+"]\n");
						
			System.out.println("---------------------");

			//insert marks
			marksService.insertMarks(selectedStudent, selectedGrade, selectedSubject);
			
			System.out.println("---------------------");
			
			//display the menu again
			menu(marksService,gradeService,studentService,subjectService);
			
		}
		else if(input == 2) {
			System.out.println("---------------------");
			
			System.out.println("Please Select a grade:");
			
			//store the grade
			String selectedGrade = gradeService.getGrade();
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[STUDENT: ] [SUBJECT: ]\n");
			
			System.out.println("Please Select a student:");
			
			//store the student
			String selectedStudent= studentService.getStudents(selectedGrade);
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[STUDENT: "+selectedStudent+"] "+"[SUBJECT: ]\n");
			
			System.out.println("Please Select a subject;");
			
			//store the subject
			String selectedSubject= subjectService.getSubjectsOfGrade(selectedGrade);
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[STUDENT: "+selectedStudent+"]"+" [SUBJECT: "+selectedSubject+"]\n");
						
			System.out.println("---------------------");

			//update marks
			marksService.updateMarks(selectedStudent, selectedSubject, selectedGrade);
			
			System.out.println("---------------------");
			
			//display the menu again
			menu(marksService,gradeService,studentService,subjectService);
		}
		else if(input == 3) {
			System.out.println("---------------------");
			
			System.out.println("Please Select a grade:");
			
			//store the grade
			String selectedGrade = gradeService.getGrade();
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[STUDENT: ] [SUBJECT: ]\n");
			
			System.out.println("Please Select a student:");
			
			//store the student
			String selectedStudent= studentService.getStudents(selectedGrade);
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[STUDENT: "+selectedStudent+"] "+"[SUBJECT: ]\n");
			
			System.out.println("Please Select a subject;");
			
			//store the subject
			String selectedSubject= subjectService.getSubjectsOfGrade(selectedGrade);
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[STUDENT: "+selectedStudent+"]"+" [SUBJECT: "+selectedSubject+"]\n");
						
			System.out.println("---------------------");

			//delete marks
			marksService.deleteMarks(selectedStudent, selectedSubject, selectedGrade);
			
			System.out.println("---------------------");
			
			//display the menu again
			menu(marksService,gradeService,studentService,subjectService);
		}
		else if(input == 4) {
			
			System.out.println("---------------------");
			
			System.out.println("Please Select a grade:");
			
			//store the grade
			String selectedGrade = gradeService.getGrade();
			
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+" [SUBJECT: ]\n");
			
			System.out.println("Please Select a subject:");
			
			//store the subject
			String selectedSubject= subjectService.getSubjectsOfGrade(selectedGrade);
			

			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[SUBJECT: "+selectedSubject+"]\n");
			
			//get all subject marks
			marksService.getSubjectMarks(selectedGrade, selectedSubject);
			
			System.out.println("---------------------");
			
			//display the menu again
			menu(marksService,gradeService,studentService,subjectService);
			
		}
		else if(input == 5) {
			
			System.out.println("---------------------");
			
			System.out.println("Please Select a grade:");
			
			//store the grade
			String selectedGrade = gradeService.getGrade();
			
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+" [SUBJECT: ]\n");
			
			System.out.println("Please Select a subject:");
			
			//store the subject
			String selectedSubject= subjectService.getSubjectsOfGrade(selectedGrade);
			

			System.out.println("---------------------");
		
			//display the highest marks in a subject
			System.out.println(marksService.getHighestMarks(selectedGrade, selectedSubject));
			
			System.out.println("---------------------");
			
			//display the menu again
			menu(marksService,gradeService,studentService,subjectService);
			
		}
		else if(input == 6) {
			
			System.out.println("---------------------");
			
			System.out.println("Please Select a grade:");
			
			//store the grade
			String selectedGrade = gradeService.getGrade();
			
			
			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+" [SUBJECT: ]\n");
			
			System.out.println("Please Select a subject:");
			
			//store the subject
			String selectedSubject= subjectService.getSubjectsOfGrade(selectedGrade);
			

			System.out.println("---------------------");
		
			//display the average marks in a subject
			System.out.println(marksService.getAvgMarks(selectedGrade, selectedSubject));
			
			System.out.println("---------------------");
			
			//display the menu again
			menu(marksService,gradeService,studentService,subjectService);
			
		}
		else if(input == 7) {
			System.out.println("Exit");
		}
		else {
			System.out.println("Invalid Input!");
			menu(marksService,gradeService,studentService,subjectService);
		}
		
	}

}
