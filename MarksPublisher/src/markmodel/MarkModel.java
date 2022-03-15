package markmodel;

public class MarkModel {

	private Integer marks;
	private String studentName;
	
	public MarkModel(Integer marks, String studentName) {
		super();
		this.setMarks(marks);
		this.setStudentName(studentName);
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
