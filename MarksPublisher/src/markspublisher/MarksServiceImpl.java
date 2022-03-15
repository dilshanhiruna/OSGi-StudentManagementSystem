package markspublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import databaseservice.Database;
import databaseservice.DatabaseImpl;
import markmodel.MarkModel;


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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHighestMarks(Integer subjectID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAvgMarks(Integer subjectID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
