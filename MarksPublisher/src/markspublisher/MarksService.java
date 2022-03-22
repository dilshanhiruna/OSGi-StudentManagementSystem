package markspublisher;


public interface MarksService {
	
	public void insertMarks(String student,String grade,String subject);
	public void updateMarks(String studentID,String subjectID,String gradeID);
	public void deleteMarks(String studentID,String subjectID,String gradeID);
	public void getSubjectMarks(String grade, String subject);
	public String getHighestMarks(String grade, String subject);
	public String getAvgMarks(String grade, String subject);
	
}
