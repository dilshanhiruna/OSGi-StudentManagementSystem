package markspublisher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import databaseservice.Database;
import databaseservice.DatabaseImpl;


public class MarksServiceImpl implements MarksService {
	
	protected ArrayList<Marks> mark = new ArrayList<Marks>();

	
	private Connection connection = null;
	private Statement statement = null;
	private Database database;
	private ResultSet resultSet;
	
	Scanner sc = new Scanner(System.in);
	

	public MarksServiceImpl() {
		super();
		
//		database = new DatabaseImpl();
//		connection = database.getDatabaseConnection();
		
		Marks mr1 = new Marks("Rochell","Grade 5","Math",90);
		Marks mr2 = new Marks("Tom","Grade 3","Math",88);
		Marks mr3 = new Marks("Haaiq","Grade 4","Science",60);
		Marks mr4 = new Marks("Katie","Grade 4","Math",67);
		
		mark.add(mr1);
		mark.add(mr2);
		mark.add(mr3);
		mark.add(mr4);
		
	}

	@Override
	public void insertMarks(String student,String grade,String subject) {
		int input;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter marks: ");
		input = Integer.parseInt(sc.next().trim());
		
		while(input>100 || input < 0) {
			System.out.println("Invalid Input!");
			System.out.println("Please enter marks again: ");
			input = Integer.parseInt(sc.next().trim());
		}
		
		mark.add(new Marks(student,grade,subject,input));
		
		System.out.println("Marks inserted for "+student+" for subject "+ subject);
		
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
	public void getSubjectMarks(String grade, String subject) {
		
		for(int i=0;i<mark.size();i++) {
			System.out.println(mark.get(i).getStudentName()+" - "+ mark.get(i).getMarks());
		}
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
