package markspublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import databaseservice.Database;
import databaseservice.DatabaseImpl;


public class MarksServiceImpl implements MarksService {
	
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	
	Scanner sc = new Scanner(System.in);
	

	public MarksServiceImpl() {
		super();
		database = new DatabaseImpl();
		connection = database.getDatabaseConnection();
	}

	
	@Override
	public void insertMarks(Integer studentID, Integer subjectID) {
		// TODO Auto-generated method stub
		
		System.out.println(studentID);
		System.out.println(subjectID);
		System.out.println("Marks inserted");
		
	}

	@Override
	public void updateMarks(Integer studentID, Integer subjectID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMarks(Integer studentID, Integer subjectID) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<MarkModel> getMarks(Integer subjectID) {
		ArrayList<MarkModel> arr = new ArrayList<>();
		MarkModel mm = new MarkModel(12,"dsfsd");
		arr.add(mm);
		// TODO Auto-generated method stub
		return arr;
	}

	@Override
	public String getHighestMarks(Integer subjectID) {
		// TODO Auto-generated method stub
		return "getHighestMarks";
	}

	@Override
	public double getAvgMarks(Integer subjectID) {
		// TODO Auto-generated method stub
		return 0.0;
	}

}
