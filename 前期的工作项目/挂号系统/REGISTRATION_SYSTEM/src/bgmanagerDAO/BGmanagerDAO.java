package bgmanagerDAO;

import bgmanager.BGM;

public interface BGmanagerDAO {
	public void save(BGM bgm);
	public void changepassword(String password);
	public String findBypassword();
	public String findByname(String name);
}
