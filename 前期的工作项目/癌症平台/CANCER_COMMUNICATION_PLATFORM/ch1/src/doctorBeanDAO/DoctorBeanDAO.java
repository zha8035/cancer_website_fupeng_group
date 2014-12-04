package doctorBeanDAO;

import doctorBean.DoctorBean;

public interface DoctorBeanDAO {
	public void save(DoctorBean doctorbean);
	
	public void delete(DoctorBean doctorbean);
	
	public void update(DoctorBean doctorbean);
	
	public DoctorBean searchBynickname(String nickname);
	
	public DoctorBean searchByname(String name);
	
	public DoctorBean searchBysubject(String subject);
	
	public DoctorBean searchByposition(String position);
}
