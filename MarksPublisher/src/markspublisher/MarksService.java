package markspublisher;


public interface MarksService {
	
	public void insertMarks(String student,String grade,String subject);
	public void updateMarks(Integer studentID,Integer subjectID);
	public void deleteMarks(Integer studentID,Integer subjectID);
	public void getSubjectMarks(String grade, String subject);
	public String getHighestMarks(Integer subject);
	public double getAvgMarks(Integer subject);
	
}
