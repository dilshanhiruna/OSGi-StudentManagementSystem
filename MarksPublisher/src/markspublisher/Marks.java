package markspublisher;

public class Marks {
	
	private Integer studentID;
	private Integer gradeID;
	private Integer subjectID;
	private String studentName;
	private String grade;
	private String subject;
	private Integer marks;
	
	public Marks(Integer studentID, Integer gradeID, Integer subjectID, String grade, String studentName, String subject, Integer marks) {
		super();
		this.studentID = studentID;
		this.gradeID = gradeID;
		this.subjectID = subjectID;
		this.grade = grade;
		this.studentName = studentName;
		this.subject = subject;
		this.marks = marks;
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	public Integer getGradeID() {
		return gradeID;
	}

	public void setGradeID(Integer gradeID) {
		this.gradeID = gradeID;
	}

	public Integer getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
	}

}
