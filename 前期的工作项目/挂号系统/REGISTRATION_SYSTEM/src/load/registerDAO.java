package load;

public interface registerDAO {
	public void Save (register Register);
	public register find();
	public int find2();
	public int find3(String subject);
	public int find4(String doctor);
	public String find5();
	public String find6bydoctor(String doctor);
}
