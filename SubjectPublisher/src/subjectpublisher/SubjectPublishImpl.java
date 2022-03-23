package subjectpublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class SubjectPublishImpl implements SubjectPublish {

	protected ArrayList<Subject> subjects = new ArrayList<Subject>();
	
	public SubjectPublishImpl() {
			
		//add default marks to marks arrayList
		subjects.add(new Subject("Grade 2", "Mathematics", "English", "Renuka"));
		subjects.add(new Subject("Grade 2", "Science", "English", "Malkanthi"));
		subjects.add(new Subject("Grade 2", "English", "English", "Senuki"));
		subjects.add(new Subject("Grade 2", "Sinhala", "English", "Renuka"));
		subjects.add(new Subject("Grade 2", "History", "English", "Karunathilaka"));
		subjects.add(new Subject("Grade 2", "Religion", "English", "Mahendra"));
		
		subjects.add(new Subject("Grade 4", "IT", "Sinhala", "Renuka"));
		subjects.add(new Subject("Grade 4", "Health", "Sinhala", "Malkanthi"));
		subjects.add(new Subject("Grade 4", "Geography", "Sinhala", "Senuki"));
		subjects.add(new Subject("Grade 4", "Tamil", "Sinhala", "Renuka"));
		subjects.add(new Subject("Grade 4", "DT", "Sinhala", "Karunathilaka"));
		subjects.add(new Subject("Grade 4", "Music", "Sinhala", "Mahendra"));
		
	}

	@Override
	//this function is used to add new subjects for a given grade
	public void addSubjects(String grade) {

		String wishToContinue = "y";
		
		while(!"n".equals(wishToContinue)) {
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Please enter the subject name : ");
			String subjectName = scan.next();
			
			System.out.print("Please enter the subject medium : ");
			String subjectMedium = scan.next();
			
			System.out.print("Please enter the teacher in charge for the subject: ");
			String teacherInCharge = scan.next();
			
			//here I can create another teacher publisher/consumer to validate teachers
			System.out.println("");

			Subject newSubject = new Subject(grade, subjectName, subjectMedium, teacherInCharge);
			subjects.add(newSubject);
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("Created new subject for grade '"+grade+"' named '"+subjectName+"' Succesfully");
			System.out.println("--------------------------------------------------------------------------------------");

			
			System.out.println("");
			
			System.out.print("Do you wish to continue? (y/n): ");
			wishToContinue = scan.next();
			while(!"y".equals(wishToContinue)&&!"n".equals(wishToContinue)) {
				System.out.print("Error! Please enter either 'y' or 'n' ");
				System.out.print("");
				System.out.print("Do you wish to continue? (y/n): ");
				wishToContinue = scan.next();
			}
		}
		
		return;
	}

	@Override
	//this function displays all the subjects in the school
	public void viewAllSubjects() {
		String wishToContinue = "y";
		Scanner scan = new Scanner(System.in);
		
		if(subjects.size()==0) {
			System.out.println("No subjects are registered yet! ");
			
		}
			
		else {
			System.out.println("------------------------------------------------------------------");
			System.out.println(
					String.format("|%-7s", "Index")
					+String.format("|%-10s", "Grade")
					+String.format("|%-15s", "Subject Name")
					+String.format("|%-10s", "Medium")
					+String.format("|%-18s|", "Teacher in Charge")
				);
			System.out.println("------------------------------------------------------------------");
			subjects.forEach((subject) -> {
				System.out.println(
					String.format("|%-7s", subjects.indexOf(subject))
					+String.format("|%-10s", subject.getGrade())
					+String.format("|%-15s", subject.getSubjectName())
					+String.format("|%-10s", subject.getSubjectMedium())
					+String.format("|%-18s|", subject.getTeacherInCharge())
				);
			});
			System.out.println("------------------------------------------------------------------");

		}	
		
		System.out.println("");
		
		System.out.print("Enter 'x' to go back to the main menu: ");
		wishToContinue = scan.next();

		while(!"x".equals(wishToContinue)) {
			System.out.print("Enter 'x' to go back to the main menu: ");
			wishToContinue = scan.next();
		}
		return;		
	}
	
	@Override
	//this function displays all the subjects in a given grade
	public void viewSubjectsOfGrade(String grade) {
		String wishToContinue = "y";
		Scanner scan = new Scanner(System.in);

		ArrayList<Subject> subjectsOfGivenGrade = printSubjectsOfGrade(grade);	
			
		System.out.println("");
		
		System.out.print("Enter 'x' to go back to the main menu: ");
		wishToContinue = scan.next();

		while(!"x".equals(wishToContinue)) {
			System.out.print("Enter 'x' to go back to the main menu: ");
			wishToContinue = scan.next();
		}
		return;
	 }


	@Override
	//this function displays all the subjects of a given grade and returns the selected subject name
	//(used in marks consumer)
	public String getSubjectsOfGrade(String grade) {
		ArrayList<Subject> subjectsOfGivenGrade = printSubjectsOfGrade(grade);
	
		if(subjectsOfGivenGrade.size()==0) {
			return "nothing";

		}
		else {	    
			int input;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter subject: ");
			input = Integer.parseInt(sc.nextLine().trim());

			return subjectsOfGivenGrade.get(input).getSubjectName();
		}
	
		
	}

	@Override
	public void editSubjects(String grade) {
		
	}

	@Override
	public void editSubjectName(ArrayList<Subject> subjects, int index) {
		
		Scanner scan = new Scanner(System.in);
		String wishToProceed = "n";
		String newSubjectName = null;

		while(!"y".equals(wishToProceed)) {
			System.out.print("Please enter the new name: ");
			newSubjectName = scan.next();
			System.out.print("Confirm change subject name from "+subjects.get(index).getSubjectName()+" to "+newSubjectName+" (y/n): ");
			wishToProceed = scan.next();
			
			while(!"y".equals(wishToProceed)&&!"n".equals(wishToProceed)) {
				System.out.print("Error! Please enter either 'y' or 'n' ");
				System.out.print("");
				System.out.print("Confirm change subject name "+subjects.get(index).getSubjectName()+" to "+newSubjectName+" (y/n): ");
				wishToProceed = scan.next();
			}
			
		}
		subjects.get(index).setSubjectName(newSubjectName);
		return;
	
	}

	@Override
	public void editSubjectMedium(ArrayList<Subject> subjects, int index) {
		Scanner scan = new Scanner(System.in);
		String wishToProceed = "n";
		String newSubjectMeduim = null;

		while(!"y".equals(wishToProceed)) {
			System.out.print("Please enter the new medium: ");
			newSubjectMeduim = scan.next();
			System.out.print("Confirm change subject medium from "+subjects.get(index).getSubjectMedium()+" to "+newSubjectMeduim+" (y/n): ");
			wishToProceed = scan.next();
			
			while(!"y".equals(wishToProceed)&&!"n".equals(wishToProceed)) {
				System.out.print("Error! Please enter either 'y' or 'n' ");
				System.out.print("");
				System.out.print("Confirm change subject medium from "+subjects.get(index).getSubjectMedium()+" to "+newSubjectMeduim+" (y/n): ");
				wishToProceed = scan.next();
			}
			
		}
		subjects.get(index).setSubjectMedium(newSubjectMeduim);
		return;		
	}

	@Override
	public void changeTeacherInCharge(ArrayList<Subject> subjects, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeTheGrade(ArrayList<Subject> subjects, int index, String newGrade) {
		
		subjects.get(index).setGrade(newGrade);
		return;	
	}

	//this function prints all the subjects of a given grade
	//(used internally to reuse code)
	@Override
	public ArrayList<Subject> printSubjectsOfGrade(String grade) {
		ArrayList<Subject> subjectsOfGivenGrade = new ArrayList<Subject>();
		
		subjects.forEach((subject) -> {
			String gradeOfSubject = subject.getGrade();
			if(gradeOfSubject==grade) {
				subjectsOfGivenGrade.add(subject);
				
			}
		});
 
		if(subjectsOfGivenGrade.size()==0) {
			System.out.println("No subjects are registered for the selected grade!");
			return subjectsOfGivenGrade;

		}		
		else {	
			System.out.println("------------------------------------------------------------------");
			System.out.println(
					String.format("|%-7s", "Index")
					+String.format("|%-10s", "Grade")
					+String.format("|%-15s", "Subject Name")
					+String.format("|%-10s", "Medium")
					+String.format("|%-18s|", "Teacher in Charge")
				);
			System.out.println("------------------------------------------------------------------");
			subjectsOfGivenGrade.forEach((subject) -> {
				System.out.println(
					String.format("|%-7s", subjectsOfGivenGrade.indexOf(subject))
					+String.format("|%-10s", subject.getGrade())
					+String.format("|%-15s", subject.getSubjectName())
					+String.format("|%-10s", subject.getSubjectMedium())
					+String.format("|%-18s|", subject.getTeacherInCharge())
				);
			});
			System.out.println("------------------------------------------------------------------");
			
			return subjectsOfGivenGrade;
		}
	}
	
	//function to delete a subject
	@Override
	public void deleteSubjects() {
		System.out.println("deleteSubjects");	
	}
}

	
