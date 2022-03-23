package studentpublisher;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

//import databaseservice.Database;
//import databaseservice.DatabaseImpl;

import studentpublisher.StudentsService;
import studentpublisher.Students;
import studentpublisher.Database;


public class StudentsServiceImpl implements StudentsService{

	
	@Override
	public synchronized int insertStudents(String studentName, int age, String grade) {
		Students newStudent = new Students(studentName, age, grade);
		Database.studentsList.add(newStudent);
		
		return 1;		
	}


	@Override
	public synchronized int updateStudents(String updatedStudentName, int updatedAge, String updatedGrade) {
		Students updateStudent = null;
		boolean invalid = true;
		int count = -1;
		
		for(Students tempStudent: Database.studentsList) {
			count++;
			
			if(tempStudent.getStudentName().equalsIgnoreCase(updatedStudentName)) {
				updateStudent = tempStudent;
				invalid = false;
				break;
			}
		}
		if(!invalid) {
			updateStudent.setStudentName(updatedStudentName);
			updateStudent.setAge(updatedAge);
			updateStudent.setGrade(updatedGrade);
			
			Database.studentsList.set(count,  updateStudent);
			return 1;
		}
		else {
			return -1;
		}		
	}


	@Override
	public synchronized int deleteStudents(String studentName) {
		boolean invalid = true;
		int count = -1;
		
		for(Students tempStudent: Database.studentsList) {
			count++;
			
			if(tempStudent.getStudentName().equalsIgnoreCase(studentName)) {
				invalid = false;
				break;
			}
		}
		if(!invalid) {
			Database.studentsList.remove(count);
			return 1;
		}
		else {
			return -1;
		}		
	}


	@Override
	public List<Students> getStudents() {		
		return Database.studentsList;
	}
	
}
