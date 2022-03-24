package assignmentpublisher;

import java.util.ArrayList;
import java.util.Scanner;


public class AssignmentServiceImpl implements AssignmentService {
	
	protected ArrayList<AssignmentModel> assignment = new ArrayList<AssignmentModel>();
	
	//this index is used in deleteSubject method
	int removeIndex = 0;
	
	Scanner sc = new Scanner(System.in);
	
	public AssignmentServiceImpl() {
		super();
		
		//add default assignments to assignment arrayList
		assignment.add(new AssignmentModel("OddManOut", "Grade 1","Engilsh"));
		assignment.add(new AssignmentModel("Maths tute", "Grade 2","Mathematics"));
		assignment.add(new AssignmentModel("Multiplication tute", "Grade 2","Mathematics"));
		assignment.add(new AssignmentModel("Geometry", "Grade 8","Mathematics"));
		assignment.add(new AssignmentModel("Python assignment", "Grade 12","IT"));
	}

	@Override
	public void addAssigments(String grade,String subject) {
		

			System.out.print("Please enter the AssignmentDetails: ");
			String enterassignment = sc.nextLine();
		
			if(enterassignment != null) {
				assignment.add(new AssignmentModel(enterassignment,grade,subject));
				
				System.out.println(enterassignment+",assignment is successfully uploaded");
				
			}else {
				System.out.println("Oops...Error occured");
			}	
		System.out.println("*****************************************************************");
	}

	@Override
	public void viewAssignmentOfGrade(String grade,String subject) {

		
		System.out.println("**********Assignment List************");
		
		for(int i=0;i<assignment.size();i++) {
			if(assignment.get(i).getGrade().equals(grade) && assignment.get(i).getSubject().equals(subject)){
				System.out.println((i+1) +" - "+ assignment.get(i).getAssignmentName());
			}
		}
		
	}

	@Override
	public void updateAssignmentOfGrades(String grade,String subject) {
		
		
		System.out.println("**********Assignment List************");
		for(int i=0;i<assignment.size();i++) {
			if(assignment.get(i).getGrade().equals(grade) && assignment.get(i).getSubject().equals(subject)){
				System.out.println((i+1) +" - "+ assignment.get(i).getAssignmentName());
			}
		}
		
		System.out.print("Enter index to update :");
		
		int input = Integer.parseInt(sc.nextLine().trim());
		
		System.out.print("Please update the assignmnet details: ");
		String assignmnetdetails = sc.nextLine();
		
		assignment.get(input-1).setAssignmentName(assignmnetdetails);
		System.out.println("Successfully Updated...");
		System.out.println("***********************************");
		
	}

	@Override
	public void removeAssignmentofGrades(String grade,String subject) {
		
		int inputgrade;
		AssignmentModel removed = null;
		
		
		System.out.println("**********Assignment List************");
		for(int i=0;i<assignment.size();i++) {
			if(assignment.get(i).getGrade().equals(grade) && assignment.get(i).getSubject().equals(subject)){
				System.out.println((i+1) +" - "+ assignment.get(i).getAssignmentName());
			}
		}
		
		System.out.print("Enter the index that wants to remove : ");
		inputgrade = Integer.parseInt(sc.nextLine().trim());
		
		removed = assignment.remove(inputgrade-1);
		
		if(removed != null) {
			System.out.println("Assignment Removed");
			System.out.println("***********************************");
		}else {
			System.out.println("No entries!");
			System.out.println("***********************************");
		}
	}

	@Override
	public void exit() {
		
		System.out.println("....Exit...");
	}

	
}
