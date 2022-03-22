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
	public void addSubjects(String grade) {
//		System.out.println("To which grade do you want to add the subject? : ");
//		
		Scanner scan = new Scanner(System.in);
//		String grade  = scan.next();
		
		System.out.println("Please enter the subject name : ");
		String subjectName = scan.next();
		
		System.out.println("Please enter the subject medium : ");
		String subjectMedium = scan.next();
		
		System.out.println("Please enter the teacher in charge for the subject: ");
		String teacherInCharge = scan.next();
		
		//here I can create another teacher publisher/consumer to validate teachers

		Subject newSubject = new Subject(grade, subjectName, subjectMedium, teacherInCharge);
		subjects.add(newSubject);
		System.out.println("Created new subject for grade "+grade+" Succesfully");
		
		return;

		
	}

	@Override
	public void viewAllSubjects() {
		System.out.println("viewAllSubjects");	
	}

	@Override
	public String getSubjectsOfGrade(String grade) {

		ArrayList<Subject> subjectsOfGivenGrade = new ArrayList<Subject>();
		
		subjects.forEach((subject) -> {
			String gradeOfSubject = subject.getGrade();
			if(gradeOfSubject==grade) {
				subjectsOfGivenGrade.add(subject);
				
			}
		});
 
		if(subjectsOfGivenGrade.size()==0) {
			System.out.println("No subjects are registered for the selected grade!");
			return "nothing";

		}
		else {
			subjectsOfGivenGrade.forEach((subject) -> {
				System.out.println(subjectsOfGivenGrade.indexOf(subject) +" - "+ subject.getSubjectName());
			});
			    
			int input;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter subject: ");
			input = Integer.parseInt(sc.nextLine().trim());

			return subjectsOfGivenGrade.get(input).getSubjectName();
		}
	
		
	}

	@Override
	public void editSubjects() {
		System.out.println("editSubjects");	
	}

	@Override
	public void deleteSubjects() {
		System.out.println("deleteSubjects");	
	}

	@Override
	public void viewSubjectsOfGrade(String grade) {
		ArrayList<Subject> subjectsOfGivenGrade = new ArrayList<Subject>();
		
	
		subjects.forEach((subject) -> {
			String gradeOfSubject = subject.getGrade();
			if(gradeOfSubject==grade) {
				subjectsOfGivenGrade.add(subject);
			}
		});
			
		if(subjectsOfGivenGrade.size()==0) {
			System.out.println("No subjects are registered for the selected grade!");
			return;
		}
			
		else {
			subjectsOfGivenGrade.forEach((subject) -> {
				System.out.println(subjectsOfGivenGrade.indexOf(subject) +" - "+ subject.getSubjectName());
			});
		}
	 }
}
