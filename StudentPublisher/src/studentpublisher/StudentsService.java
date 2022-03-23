package studentpublisher;

import java.util.List;

import studentpublisher.Students;

public interface StudentsService {
	
	public int insertStudents(String studentName,int age,String grade);
	public int updateStudents(String updatedStudentName,int updatedAge,String updatedGrade);
	public int deleteStudents(String studentName);
	public List<Students> getStudents();

}
