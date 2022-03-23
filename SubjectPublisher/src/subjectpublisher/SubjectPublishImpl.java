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
		
		subjects.add(new Subject("Grade 4", "Information Technology", "Sinhala", "Renuka"));
		subjects.add(new Subject("Grade 4", "Health", "Sinhala", "Malkanthi"));
		subjects.add(new Subject("Grade 4", "Geography", "Sinhala", "Senuki"));
		subjects.add(new Subject("Grade 4", "Tamil", "Sinhala", "Renuka"));
		subjects.add(new Subject("Grade 4", "Design and Technology", "Sinhala", "Karunathilaka"));
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
			System.out.println("-----------------------------------------------------");
			System.out.println("Created new subject for grade "+grade+" named "+subjectName+" Succesfully");
			System.out.println("-----------------------------------------------------");

			
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
			subjects.forEach((subject) -> {
				System.out.println(subjects.indexOf(subject) +" - "+ subject.getSubjectName());
			});
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
		ArrayList<Subject> subjectsOfGivenGrade = printSubjectsOfGrade(grade);
		
		if(subjectsOfGivenGrade.size()!=0) {
			    
			int index;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter subject: ");
			index = Integer.parseInt(sc.nextLine().trim());
			
			System.out.println("What do you want to do with " +subjectsOfGivenGrade.get(index).getSubjectName()+" ?: ");
			System.out.println("");
			System.out.println("Press 1 to Edit subject name");
			System.out.println("Press 2 to Edit subject medium");
			System.out.println("Press 3 to Edit subject teacher in charge");
			System.out.println("Press 4 to Move subject to another grade");
			
			System.out.println("");
			System.out.print("Please select the service you wish to continue: ");
			System.out.println("");
			int editService = Integer.parseInt(sc.nextLine().trim());

			
			switch (editService) {
				case 1:
					editSubjectName(subjectsOfGivenGrade, index);
					break;
				case 2:
					editSubjectMedium(subjectsOfGivenGrade, index);
					break;
				case 3:
					changeTeacherInCharge(subjectsOfGivenGrade, index);
					break;
				case 4:
					changeTheGrade(subjectsOfGivenGrade, index);
					break;
				default:
					System.out.println("Error! Invalid number");
					break;
			
			}

		}
	}

	@Override
	public void deleteSubjects() {
		System.out.println("deleteSubjects");	
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
	public void changeTheGrade(ArrayList<Subject> subjects, int index) {
		// TODO Auto-generated method stub
		
	}

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
			subjectsOfGivenGrade.forEach((subject) -> {
				System.out.println(subjectsOfGivenGrade.indexOf(subject) +" - "+ subject.getSubjectName());
			});
			
			return subjectsOfGivenGrade;
		}
	}
}

	
