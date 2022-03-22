package subjectpublisher;

public interface SubjectPublish {
	
	public void addSubjects(String grade);
	public void viewAllSubjects();
	public void viewSubjectsOfGrade(String grade);
	public String getSubjectsOfGrade(String grade);
	public void editSubjects();
	public void deleteSubjects();

}
