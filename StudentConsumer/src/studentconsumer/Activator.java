package studentconsumer;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import studentpublisher.Students;
import studentpublisher.StudentsService;


public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	Scanner input = new Scanner(System.in);
	
	boolean exit = false;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Student Consumer Started");
		serviceReference = context.getServiceReference(StudentsService.class.getName());
		
		@SuppressWarnings("unchecked")
		StudentsService studentsService = (StudentsService)context.getService(serviceReference);
		
		do {
			int value;
			
			do {
				System.out.println("======================================================");
				System.out.println("Welcome to the Student Management System"+ "\n");
				
				System.out.println("To continue, please select an option"+ "\n");
				
				System.out.println("Options:");				
				System.out.println("1) Add a new student");
				System.out.println("2) Update the details of an existing student");
				System.out.println("3) Delete a student");
				System.out.println("4) Show all students");
				System.out.println("5) Exit"+ "\n");
				
				System.out.println("Please enter your option");
				
				value = input.nextInt();
				
				input.nextLine();
				
				if(value == 5) {
					exit = true;
				}
				
				if(value != 1 && value != 2 && value != 3 && value != 4 && value != 5) {
					System.out.println("Incorrect option. Please enter a valid option");
				}
			}
			while(value != 1 && value != 2 && value != 3 && value != 4 && value != 5);
			
			String home = null;
			
			if(value == 1) {
				do {
					System.out.println("Student Name");
					String studentName = input.nextLine();
					
					System.out.println("Age");
					int age = input.nextInt();
					
					System.out.println("Grade");
					//String grade = input.nextLine();
					String grade = input.next();
					
					input.nextLine();
					//input.next();
					
					int result = studentsService.insertStudents(studentName, age, grade);
					
					String message = (result == 1) ? "Student is successfully added to the system" : "Please enter a valid value";
					System.out.println(message);
					
					System.out.println("Enter 0 to navigate Home or enter any other value to continue");
					home = input.nextLine();
				}
				while(!(home.equals("0")));
			}
			else if(value == 2) {
				do {
					System.out.println("Student Name");
					String updatedStudentName = input.nextLine();
					
					System.out.println("Age");
					int updatedAge = input.nextInt();
					
					System.out.println("Grade");
					//String updatedGrade = input.nextLine();
					String updatedGrade = input.next();
					
					input.nextLine();
					
					int result = studentsService.updateStudents(updatedStudentName, updatedAge, updatedGrade);
					
					String message = (result == 1) ? "Student details are successfully updated" : "Please enter a valid value";
					System.out.println(message);
					
					System.out.println("Enter 0 to navigate Home or enter any other value to continue");
					home = input.nextLine();
				}
				while(!(home.equals("0")));
			}
			else if(value == 3) {
				do {
					System.out.println("Please enter the student name");
					
					String studentName = input.nextLine();
					
					int result = studentsService.deleteStudents(studentName);
					
					String message = (result == 1) ? "Student is deleted successfully" : "Please enter a valid value";
					System.out.println(message);
					
					System.out.println("Enter 0 to navigate Home or enter any other value to continue");
					home = input.nextLine();
				}
				while(!(home.equals("0")));
			}
			else if(value == 4) {
				do {
					List<Students> studentsList = studentsService.getStudents();
					
					System.out.println("List of the Students");
					System.out.println("Student Name"+"\t" + "Age"+"\t" + "Grade"+"\t");
					
					for(Students tempStudent: studentsList) {
						System.out.println(tempStudent.getStudentName()+"\t        "+tempStudent.getAge()+"\t       "+tempStudent.getGrade()+"\t"+"\n");
					}
					System.out.println("===============================");
					
					System.out.println("Enter 0 to navigate Home or enter any other value to continue");
					home = input.nextLine();					
				}
				while(!(home.equals("0")));
			}
			else if(value == 5) {
				return;
			}
		}
		while(!exit);
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Students Consumer Stops");
		context.ungetService(serviceReference);
	}
	

}
