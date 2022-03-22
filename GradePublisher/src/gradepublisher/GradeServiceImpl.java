package gradepublisher;

import java.util.ArrayList;
import java.util.Scanner;


public class GradeServiceImpl implements GradeService {

	private ArrayList<String> grades = new ArrayList<String>();
	
	public GradeServiceImpl() {
		super();
		grades.add("A");
		grades.add("B");
		grades.add("C");
		grades.add("D");
		grades.add("E");
		grades.add("F");
	}

	@Override
	public void getGrade() {
		
		for(int i=0;i<grades.size();i++) {
			//System.out.println(i +"- "+ grades.get(i));
			System.out.println(i);
		}

	}

	
	@Override
	public void insertGrades() {
		String inputgrade;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter grade: ");
		inputgrade = sc.nextLine();
		
		if(inputgrade == null) {
			System.out.println("\nInvalid input...");
			System.out.print("Please enter grade: ");
			inputgrade = sc.nextLine();
		}
		
		grades.add(inputgrade);
		
		System.out.println("Grade "+inputgrade+" is successfully inserted");
	}

	@Override
	public void updateGrades() {
		String inputgrade;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<grades.size();i++) {
				
				System.out.print("Please enter new grade: ");
				inputgrade = sc.next();
				
				grades.get(i).setGrade(inputgrade);
				
				System.out.println("Grade updated succesfully!");
		}
		
	}

	@Override
	public void deleteGrades() {
		
		
	}

}
