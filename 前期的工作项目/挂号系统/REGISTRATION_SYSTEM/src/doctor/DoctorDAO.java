package doctor;

public interface DoctorDAO {
	public void Save (DoctorR Doctor);
	public String findByname (String name);
}
