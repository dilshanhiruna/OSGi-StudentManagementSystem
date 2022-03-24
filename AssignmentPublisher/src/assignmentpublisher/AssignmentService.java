package assignmentpublisher;

public interface AssignmentService {
	
	public void addAssigments(String grade,String subject);
	public void viewAssignmentOfGrade(String grade,String subject);
	public void updateAssignmentOfGrades(String grade,String subject);
	public void removeAssignmentofGrades(String grade,String subject);
	public void exit();

}
