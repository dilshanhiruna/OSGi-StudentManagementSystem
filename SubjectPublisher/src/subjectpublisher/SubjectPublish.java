package subjectpublisher;

import java.util.ArrayList;

public interface SubjectPublish {
	
	public void addSubjects(String grade);
	public void viewAllSubjects();
	public void viewSubjectsOfGrade(String grade);
	public String getSubjectsOfGrade(String grade);
	public void editSubjects(String grade);
	public void editSubjectName(ArrayList<Subject> subjects, int index);
	public void editSubjectMedium(ArrayList<Subject> subjects, int index);
	public void changeTeacherInCharge(ArrayList<Subject> subjects, int index);
	public void changeTheGrade(ArrayList<Subject> subjects, int index, String newGrade);
	public ArrayList<Subject> printSubjectsOfGrade(String grade);


	public void deleteSubjects();

}
