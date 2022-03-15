package markspublisher;

import java.util.ArrayList;

import markmodel.MarkModel;

public interface MarksService {
	
	public void insertMarks(Integer studentID,Integer subjectID);
	public void updateMarks(Integer studentID,Integer subjectID);
	public void deleteMarks(Integer studentID,Integer subjectID);
	public ArrayList<MarkModel> getMarks(Integer subjectID);
	public String getHighestMarks(Integer subjectID);
	public double getAvgMarks(Integer subjectID);
	
}
