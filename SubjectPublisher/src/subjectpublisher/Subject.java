package subjectpublisher;

public class Subject {

	private String grade;
	private String subjectName;
	private String subjectMedium;
	private String teacherInCharge;
	
	public Subject(String grade, String subjectName, String subjectMedium, String teacherInCharge) {
		super();
		this.grade = grade;
		this.subjectName = subjectName;
		this.subjectMedium = subjectMedium;
		this.teacherInCharge = teacherInCharge;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectMedium() {
		return subjectMedium;
	}

	public void setSubjectMedium(String subjectMedium) {
		this.subjectMedium = subjectMedium;
	}

	public String getTeacherInCharge() {
		return teacherInCharge;
	}

	public void setTeacherInCharge(String teacherInCharge) {
		this.teacherInCharge = teacherInCharge;
	}
	
}
