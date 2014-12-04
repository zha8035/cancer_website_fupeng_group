package patient;

import java.util.ArrayList;

import patientDAOImpl.PatientDAOImpl;

public class PatientInfoList {
	private ArrayList<PatientInfo> patientinfolist = new ArrayList<PatientInfo>();
	PatientDAOImpl pdi = new PatientDAOImpl(); 
	
	public PatientInfoList(String nametext){
		PatientInfo pf = new PatientInfo();
		pf = pdi.findByname(nametext);
		patientinfolist.add(pf);
	}
	public ArrayList<PatientInfo> getPatientInfoList(){
		return  patientinfolist;
	}
}
