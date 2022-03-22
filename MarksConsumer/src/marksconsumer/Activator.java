package marksconsumer;

import grdp.GradeInterface;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import stup.StudentInterface;
import subp.SubjectInterface;
import markspublisher.MarksService;

public class Activator implements BundleActivator {

	ServiceReference sr1,sr2,sr3,sr4;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Marks Consumer Starts");
		sr1 = context.getServiceReference(MarksService.class.getName());
		sr2 = context.getServiceReference(GradeInterface.class.getName());
		sr3 = context.getServiceReference(StudentInterface.class.getName());
		sr4 = context.getServiceReference(SubjectInterface.class.getName());
		
		if(sr1 != null  || sr2 != null || sr3 != null || sr4 != null ) {
			@SuppressWarnings("unchecked")
			MarksService marksService = (MarksService)context.getService(sr1);
			@SuppressWarnings("unchecked")
			GradeInterface gradeService = (GradeInterface) context.getService(sr2);
			@SuppressWarnings("unchecked")
			StudentInterface studentService = (StudentInterface) context.getService(sr3);
			@SuppressWarnings("unchecked")
			SubjectInterface subjectService = (SubjectInterface) context.getService(sr4);
			
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
	
	public void menu(MarksService marksService,GradeInterface gradeService,StudentInterface studentService,SubjectInterface subjectService) {
		
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
		
		System.out.println("Enter (1/2/3/4/5/6): ");
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
			String selectedSubject= subjectService.getSubjects(selectedGrade);
			
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
			menu(marksService,gradeService,studentService,subjectService);
		}
		else if(input == 3) {
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
			String selectedSubject= subjectService.getSubjects(selectedGrade);
			

			System.out.println("---------------------");
			System.out.println("[GRADE: "+selectedGrade+"] "+"[SUBJECT: "+selectedSubject+"]\n");
			
			//get all subject marks
			marksService.getSubjectMarks(selectedGrade, selectedSubject);
			
			System.out.println("---------------------");
			
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
			String selectedSubject= subjectService.getSubjects(selectedGrade);
			

			System.out.println("---------------------");
		
			//get highest marks in a subject
			
			System.out.println(marksService.getHighestMarks(selectedGrade, selectedSubject));
			
			System.out.println("---------------------");
			
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
			String selectedSubject= subjectService.getSubjects(selectedGrade);
			

			System.out.println("---------------------");
		
			//get highest marks in a subject
			
			System.out.println(marksService.getAvgMarks(selectedGrade, selectedSubject));
			
			System.out.println("---------------------");
			
			menu(marksService,gradeService,studentService,subjectService);
			
		}
		
	}

}
