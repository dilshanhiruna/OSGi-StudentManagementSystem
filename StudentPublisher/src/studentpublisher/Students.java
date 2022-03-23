package studentpublisher;

public class Students {
	
	private String studentName;
	private int age;
	private String grade;
	
	
	public Students(String studentName, int age, String grade) {
		super();
		this.studentName = studentName;
		this.age = age;
		this.grade = grade;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
