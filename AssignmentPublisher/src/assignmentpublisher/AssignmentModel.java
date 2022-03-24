package assignmentpublisher;

public class AssignmentModel {
	
	private String assignmentName;
	private String grade;
	private String subject;
	
	public AssignmentModel() {
	}

	public AssignmentModel(String assignmentName, String grade,String subject) {
		super();
		this.assignmentName = assignmentName;
		this.grade = grade;
		this.subject = subject;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	

}
