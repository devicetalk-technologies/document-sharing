package in.co.devicetalk.documentsharing;

public class StudentRegistrationRequest {
	private Student student;
	
	private String password;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
