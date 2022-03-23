package subjectconsumer;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import gradepublisher.GradeService;
import subjectpublisher.Subject;
import subjectpublisher.SubjectPublish;
import teacherpublisher.TeacherPublish;

public class SubjectActivator implements BundleActivator {

	ServiceReference serviceReferenceSubject;
	ServiceReference serviceReferenceGrade;
	ServiceReference serviceReferenceTeacher;
	SubjectPublish subjectPublish;
	GradeService gradeService;
	TeacherPublish teacherPublish;



	public void start(BundleContext bundleContext) throws Exception {
		serviceReferenceSubject = bundleContext.getServiceReference(SubjectPublish.class.getName());
		subjectPublish = (SubjectPublish) bundleContext.getService(serviceReferenceSubject);
		
		serviceReferenceGrade = bundleContext.getServiceReference(GradeService.class.getName());
		gradeService = (GradeService) bundleContext.getService(serviceReferenceGrade);
		
		serviceReferenceTeacher = bundleContext.getServiceReference(TeacherPublish.class.getName());
		teacherPublish = (TeacherPublish) bundleContext.getService(serviceReferenceTeacher);
		
		loopService();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Subject service consumer stopeed!");
		bundleContext.ungetService(serviceReferenceSubject);
		bundleContext.ungetService(serviceReferenceGrade);
		bundleContext.ungetService(serviceReferenceTeacher);
	}
	
	//method to loop service(get and direct user for a service)
	public void loopService() {
		int selectedService = selectService();
		directToService(selectedService);
	}
	
	//method to display and get selected service from the user
	public int selectService() {
		
		System.out.println("");
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Welcome to student service!");
		System.out.println("---------------------------");
		
		System.out.println("");
		System.out.println("Here are the services available to you: ");
		System.out.println("------------------------------------------------------");
		System.out.println("Press 1 to Add new subject");
		System.out.println("Press 2 to View all the subjects of the school");
		System.out.println("Press 3 to View all the subjects of a perticular grade");
		System.out.println("Press 4 to Edit subject details");
		System.out.println("Press 5 to Detele subjects");
		System.out.println("Press 0 to Quit service");
		System.out.println("------------------------------------------------------");


		System.out.println("");
		System.out.print("Please select the service you wish to continue: ");
		System.out.println("");



		
		Scanner scan = new Scanner(System.in);
		int input  = scan.nextInt();
		
		return input;
	}
	
	//method to direct user to the selected service
	public void directToService(int selectedService) {
		
		//add new subject
		if(selectedService==1) {
			System.out.println("");
			System.out.println("Please Select a grade:");
			String selectedGrade = gradeService.getGrade();
			System.out.println("");
			
			System.out.println("");
			System.out.println("Please select the teacher in charge for the subject:");
			String selectedTeacher = teacherPublish.getTeacher();
			System.out.println("");

			System.out.println("---------------------");
			subjectPublish.addSubjects(selectedGrade, selectedTeacher);
		}
		
		//view all subjects of the school
		else if(selectedService==2) {
			subjectPublish.viewAllSubjects();
		}
		
		//view all subjects of a particular grade
		else if(selectedService==3) {
			System.out.println("");
			System.out.println("Please Select a grade:");
			String selectedGrade = gradeService.getGrade();
			System.out.println("");
			subjectPublish.viewSubjectsOfGrade(selectedGrade);;
		}
		
		//edit subject details
		else if(selectedService==4) {
			System.out.println("");
			System.out.println("Please Select a grade:");
			String selectedGrade = gradeService.getGrade();
			System.out.println("");
			
			ArrayList<Subject> subjectsOfGivenGrade = subjectPublish.printSubjectsOfGrade(selectedGrade);
			
			if(subjectsOfGivenGrade.size()!=0) {
				    
				int index;
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter subject index to edit: ");
				index = Integer.parseInt(sc.nextLine().trim());
				index--;
				
				System.out.println("What do you want to do with " +subjectsOfGivenGrade.get(index).getSubjectName()+"?: ");
				System.out.println("");
				System.out.println("Press 1 to Edit subject name");
				System.out.println("Press 2 to Edit subject medium");
				System.out.println("Press 3 to Edit subject teacher in charge");
				System.out.println("Press 4 to Move subject to another grade");
				
				System.out.println("");
				System.out.print("Please select the service you wish to continue: ");
				System.out.println("");
				int editService = Integer.parseInt(sc.nextLine().trim());
				Scanner scan = new Scanner(System.in);

				
				switch (editService) {
					case 1:
						//edit subject name
						subjectPublish.editSubjectName(subjectsOfGivenGrade, index);
						break;
					case 2:
						//edit subject medium
						subjectPublish.editSubjectMedium(subjectsOfGivenGrade, index);
						break;
					case 3:
						//change teacher in charge						
						String wishToProceed = "n";
						String newTeacher = "";

						while(!"y".equals(wishToProceed)) {
							System.out.println("To which teacher do you want to move the subject?");
							newTeacher = teacherPublish.getTeacher();
							System.out.println("");
							System.out.print("Confirm change subject teacher to '"+newTeacher+"' (y/n) | press x to terminate : ");
							wishToProceed = scan.next();
							if(wishToProceed.equals("x")) {
								loopService();
							}
							
							while(!"y".equals(wishToProceed)&&!"n".equals(wishToProceed)) {
								System.out.print("Error! Please enter either 'y' or 'n' ");
								System.out.print("");
								System.out.print("Confirm change subject grade to '"+newTeacher+"' (y/n) | press x to terminate : ");
								wishToProceed = scan.next();
								if(wishToProceed.equals("x")) {
									loopService();
								}
							}
							
						}
						subjectPublish.changeTeacherInCharge(subjectsOfGivenGrade, index, newTeacher);

						break;
						
						
					case 4:			
						//change grade
						wishToProceed = "n";
						String newSubjectGrade = null;
						String newGrade = "";

						while(!"y".equals(wishToProceed)) {
							System.out.println("To which grade do you want to move the subject?");
							newGrade = gradeService.getGrade();
							System.out.println("");
							System.out.print("Confirm change subject grade to '"+newGrade+"' (y/n) | press x to terminate : ");
							wishToProceed = scan.next();
							if(wishToProceed.equals("x")) {
								loopService();
							}
							
							while(!"y".equals(wishToProceed)&&!"n".equals(wishToProceed)) {
								System.out.print("Error! Please enter either 'y' or 'n' ");
								System.out.print("");
								System.out.print("Confirm change subject grade to '"+newGrade+"' (y/n) | press x to terminate : ");
								wishToProceed = scan.next();
								if(wishToProceed.equals("x")) {
									loopService();
								}
							}
							
						}
						subjectPublish.changeTheGrade(subjectsOfGivenGrade, index, newGrade);

						break;
					default:
						System.out.println("Error! Invalid number");
						break;
				
				}

			}		
		}
		else if(selectedService==5) {
			System.out.println("");
			System.out.println("Please Select a grade:");
			String selectedGrade = gradeService.getGrade();
			System.out.println("");
			
			ArrayList<Subject> subjectsOfGivenGrade = subjectPublish.printSubjectsOfGrade(selectedGrade);
			
			if(subjectsOfGivenGrade.size()!=0) {
				    
				String wishToProceed = "n";
				String newSubjectGrade = null;
				String newGrade = "";
				int index = 0;

				
				while(!"y".equals(wishToProceed)) {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter subject index to delete: ");
					index = Integer.parseInt(sc.nextLine().trim());
					index--;
					System.out.println("");
					System.out.print("Confirm delete subject? (y/n) | press x to terminate : ");
					wishToProceed = sc.next();
					if(wishToProceed.equals("x")) {
						loopService();
					}
					
					while(!"y".equals(wishToProceed)&&!"n".equals(wishToProceed)) {
						System.out.print("Error! Please enter either 'y' or 'n' ");
						System.out.print("");
						System.out.print("Confirm delete subject? (y/n) | press x to terminate : ");
						wishToProceed = sc.next();
						if(wishToProceed.equals("x")) {
							loopService();
						}
					}
					
				}
				
				subjectPublish.deleteSubject(subjectsOfGivenGrade, index);

				
			}
		}

		else if(selectedService==0) {
			System.out.println("-----------------------------");
			System.out.println("Thank you... Have a nice day!");
			System.out.println("-----------------------------");

		}
		else {
			System.out.println("Please enter a valid service number");
		}
		loopService();
	}

}

