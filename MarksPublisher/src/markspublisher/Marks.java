package markspublisher;

public class Marks {
	

	private String studentName;
	private String grade;
	private String subject;
	private Integer marks;
	
	public Marks(String studentName, String grade, String subject, Integer marks) {
		super();
		this.studentName = studentName;
		this.grade = grade;
		this.subject = subject;
		this.marks = marks;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

}
