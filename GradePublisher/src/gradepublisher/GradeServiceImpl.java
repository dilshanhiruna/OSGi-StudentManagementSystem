package gradepublisher;

import java.util.ArrayList;
import java.util.Scanner;


public class GradeServiceImpl implements GradeService {

	private ArrayList<GradeModel> grades = new ArrayList<GradeModel>();
	
	public GradeServiceImpl() {
		super();
		
		grades.add(new GradeModel("Grade 1"));
		grades.add(new GradeModel("Grade 2"));
		grades.add(new GradeModel("Grade 3"));
		grades.add(new GradeModel("Grade 4"));
		grades.add(new GradeModel("Grade 5"));
		grades.add(new GradeModel("Grade 6"));
	}

	@Override
	public String getGrade() {
		
		int input;

		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<grades.size();i++) {
			System.out.println(i +" - "+ grades.get(i));
		}
		    
		System.out.println("Enter grade: ");
		input = Integer.parseInt(sc.nextLine().trim());

		return grades.get(input).getGrade();

	}
	
	
	@Override
	public void insertGrades() {
		String inputgrade;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter grade: ");
		inputgrade = sc.nextLine();
		
		if(inputgrade != null) {
			grades.add(new GradeModel(inputgrade));
			
			System.out.println(inputgrade+" is successfully inserted");
			System.out.println("***********************************");
		}else {
		
			System.out.println("\nInvalid input...");
//			System.out.print("Please enter grade: ");
//			inputgrade = sc.nextLine();
			insertGrades();
		
		}
	}

	@Override
	public void updateGrades() {
		String inputgrade;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**********Grade List************");
		for(int i=0;i<grades.size();i++) {
			System.out.println((i+1) +" - "+ grades.get(i).getGrade());
		}

		System.out.print("Enter index to update :");
		
		int input = Integer.parseInt(sc.nextLine().trim());
		
		System.out.print("Please enter new grade: ");
		inputgrade = sc.nextLine();
		
		grades.get(input-1).setGrade(inputgrade);
		System.out.println("Successfully Updated...");
		System.out.println("***********************************");
		
	}

	@Override
	public void deleteGrades() {
		int inputgrade;
		GradeModel removed = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**********Grade List************");
		for(int i=0;i<grades.size();i++) {
			System.out.println((i+1) +" - "+ grades.get(i).getGrade());
		}
		
		System.out.print("Enter the grade that wants to remove : ");
		inputgrade = Integer.parseInt(sc.nextLine().trim());
		
		removed = grades.remove(inputgrade-1);
		
		if(removed != null) {
			System.out.println("Grade Removed");
			System.out.println("***********************************");
		}else {
			System.out.println("No entries!");
			System.out.println("***********************************");
		}
		
	}

	@Override
	public void listGrades() {
		System.out.println("**********Grade List************");
		for(int i=0;i<grades.size();i++) {
			System.out.println((i+1) +" - "+ grades.get(i).getGrade());
		}
	}

}
