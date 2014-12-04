package patientBeanDAO;

import patientBean.PatientBean;

public interface PatientBeanDAO {
	public void save(PatientBean patientbean);
	
	public void delete(PatientBean patientbean);
	
	public void update(PatientBean patientbean);
	
	public PatientBean searchBynickname(String nickname);
	
	public PatientBean searchByname(String name);
	
	public PatientBean searchBysubject(String name);
		
}
