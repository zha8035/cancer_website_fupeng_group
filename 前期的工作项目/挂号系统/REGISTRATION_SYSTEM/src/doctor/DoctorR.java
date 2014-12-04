package doctor;

public class DoctorR {
	private int Id;
	private String name;
	private String password;
	private String pwpassword;
	private String subject;
	private String position;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPwpassword() {
		return pwpassword;
	}
	public void setPwpassword(String pwpassword) {
		this.pwpassword = pwpassword;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
