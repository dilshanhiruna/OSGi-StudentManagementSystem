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
		
		//add default marks to marks arrayList
		mark.add(new Marks("Rochell","Grade 5","Math",90));
		mark.add(new Marks("Tom","Grade 3","Math",88));
		mark.add(new Marks("Haaiq","Grade 4","Science",60));
		mark.add(new Marks("Katie","Grade 4","Math",67));
		mark.add(new Marks("Jasmin","Grade 4","Math",66));
		mark.add(new Marks("Natalia","Grade 4","Math",80));
		mark.add(new Marks("Jenny","Grade 4","Math",45));
		
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
		//printout all the student with marks
		for(int i=0;i<mark.size();i++) {
			if(mark.get(i).getGrade() == grade && mark.get(i).getSubject() == subject) {
			System.out.println(mark.get(i).getStudentName()+" - "+ mark.get(i).getMarks());
			}
		}
	}

	@Override
	public String getHighestMarks(String grade, String subject){
		
		Integer higestMarks =0;
		String student ="";
		
		for(int i=0;i<mark.size();i++) {
			
			if(mark.get(i).getGrade() == grade && mark.get(i).getSubject() == subject) {
				
				if(higestMarks<mark.get(i).getMarks()) {
					higestMarks = mark.get(i).getMarks();
					student = mark.get(i).getStudentName();
				}
				
			}
			
		}
		if(!student.equals("")) {
			return "Highest Score for "+grade+" "+subject+" is: "+student + " - " +higestMarks+"%" ;
		}else {
			return "No entries!"; 
		}
		
	}

	@Override
	public String getAvgMarks(String grade, String subject) {
		int count =0;
		double total =0.0;
		
		for(int i=0;i<mark.size();i++) {
			if(mark.get(i).getGrade() == grade && mark.get(i).getSubject() == subject) {
			total+=mark.get(i).getMarks();
			count++;
			}
		}
		if(count>0 && total > 0.0) {
			return "Average marks for "+grade+" "+subject+" is: "+ total/count ;
		}else {
			return "No entries!"; 
		}
		
	
	}

}
