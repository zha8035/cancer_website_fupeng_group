package searchbeanDAO;

import searchbean.SearchBean;

public interface SearchBeanDAO {
	public SearchBean SearchByname(String name);
	public SearchBean SearchByage(int age);
	public SearchBean SearchBysex(String sex);
	public SearchBean SearchByhpspital(String hospital);
	public SearchBean SearchByposition(String position);
	public SearchBean SearchByadisname(String dianame);
	
}
