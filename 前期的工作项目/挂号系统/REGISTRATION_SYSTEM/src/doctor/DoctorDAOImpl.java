package doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnectPool.DBConnectPool;

public class DoctorDAOImpl implements DoctorDAO{
	
	public void Save(DoctorR doctor) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "insert into db2.doctor(name,password,pwpassword,subject,position) values(?,?,?,?,?)";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, doctor.getName());
			stem.setString(2, doctor.getPassword());
			stem.setString(3, doctor.getPwpassword());
			stem.setString(4, doctor.getSubject());
			stem.setString(5, doctor.getPosition());
			stem.executeUpdate();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public String findByname(String name) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "select password from db2.doctor where name=?";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, name);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				return rs.getString("password");
			}
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
