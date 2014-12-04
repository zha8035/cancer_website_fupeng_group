package pdtableDAO;

public interface PDtableDAO {
	public int findByname1 (String  name);
	public String findByname2(String  name,int m,int n);
	public void Save(String subject, String doctorname);
}
