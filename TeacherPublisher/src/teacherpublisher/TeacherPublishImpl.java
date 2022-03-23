package teacherpublisher;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherPublishImpl implements TeacherPublish {

	protected ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	//this index is used in deleteTeacher method
	int removeIndex = 0;
	
	public TeacherPublishImpl() {
		//add default marks to marks arrayList
		teachers.add(new Teacher("Malkanthi", "Female", "Kottawa"));
		teachers.add(new Teacher("Rukantha", "Male", "Maharagama"));
		teachers.add(new Teacher("Gunawardana", "Male", "Nugegoda"));
		teachers.add(new Teacher("Renuka", "Female", "Embilipitiya"));
		teachers.add(new Teacher("Jayanthi", "Female", "Homagama"));
		
	}
	
	@Override
	public void addNewTeacher() {
		String wishToContinue = "y";
		while(!"n".equals(wishToContinue)) {
			Scanner scan = new Scanner(System.in);		
			System.out.print("Please enter the name : ");
			String name = scan.next();			
			System.out.print("Please enter the gender : ");
			String gender = scan.next();		
			System.out.print("Please enter the address: ");
			String address = scan.next();
		
			System.out.println("");
			Teacher newTeacher = new Teacher(name, gender, address);
			teachers.add(newTeacher);
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("Created new teacher named '"+name+"' Succesfully");
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("");
			System.out.print("Do you wish to continue? (y/n): ");
			wishToContinue = scan.next();
			while(!"y".equals(wishToContinue)&&!"n".equals(wishToContinue)) {
				System.out.print("Error! Please enter either 'y' or 'n' ");
				System.out.print("");
				System.out.print("Do you wish to continue? (y/n): ");
				wishToContinue = scan.next();
			}
		}
		return;		
	}

	@Override
	public void viewAllTeachers() {
		printTeachers();
	}

	@Override
	public String getTeacher() {
		printTeachers();

		if(teachers.size()==0) {
			return "nothing";
		}
		else {	    
			int input;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter teacher index: ");
			input = Integer.parseInt(sc.nextLine().trim());

			return teachers.get(--input).getName();
		}			
	}

	@SuppressWarnings("resource")
	@Override
	public void deleteTeacher() {
		
		printTeachers();
		
		if(teachers.size()!=0) {
			String wishToProceed = "n";
			String newSubjectGrade = null;
			String newGrade = "";
			int index = 0;

			while(!"y".equals(wishToProceed)) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter teacher index to delete: ");
				index = Integer.parseInt(sc.nextLine().trim());
				index--;
				System.out.println("");
				System.out.print("Confirm delete teacher? (y/n) | press x to terminate : ");
				wishToProceed = sc.next();
				if(wishToProceed.equals("x")) {
					return;
				}
				
				while(!"y".equals(wishToProceed)&&!"n".equals(wishToProceed)) {
					System.out.print("Error! Please enter either 'y' or 'n' ");
					System.out.print("");
					System.out.print("Confirm delete teacher? (y/n) | press x to terminate : ");
					wishToProceed = sc.next();
					if(wishToProceed.equals("x")) {
						return;
					}
				}
				
			}		
			teachers.remove(index);	
			viewAllTeachers();
		}	
		
	}

	@Override
	public void printTeachers() {
		if(teachers.size()==0) {
			System.out.println("No subjects are registered for the selected grade!");
		}		
		else {	
			System.out.println("------------------------------------------------------");
			System.out.println(
					String.format("|%-7s", "Index")
					+String.format("|%-15s", "Teacher Name")
					+String.format("|%-10s", "Gender")
					+String.format("|%-17s|", "Address")
				);
			System.out.println("------------------------------------------------------");
			teachers.forEach((teacher) -> {
				System.out.println(
					String.format("|%-7s", teachers.indexOf(teacher)+1)
					+String.format("|%-15s", teacher.getName())
					+String.format("|%-10s", teacher.getGender())
					+String.format("|%-17s|", teacher.getAddress())
				);
			});
			System.out.println("------------------------------------------------------");
		}		
	}

	
}

	
