package load;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnectPool.DBConnectPool;

public class RegisterDAOImpl implements registerDAO{
	
	public void Save(register Register) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "insert into db2.register(name,subject,doctor) values(?,?,?)";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, Register.getName());
			stem.setString(2, Register.getSubject());
			stem.setString(3, Register.getDoctor());
			stem.executeUpdate();
			stem.close();
			con.close();
			System.out.println("succes");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public register find(){
		register Register = new register();
		Connection con = null;
		String sql = "select * from db2.patient";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			ResultSet rs = stem.executeQuery();
/*			while(rs.next()){
				i++;
			}*/
			while(rs.next()){
				Register.setId(rs.getInt("Id"));
				Register.setName(rs.getString("name"));
				Register.setDoctor(rs.getString("doctor"));
				Register.setSubject(rs.getString("subject"));
				return Register;
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
		
	}
	public int find2() {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "select * from db2.register";
		int i = 0;
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				i++;
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
	public int find3(String subject) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "select * from db2.register where subject=?";
		int i = 0;
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, subject);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				i++;
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
	public int find4(String doctor) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "select * from db2.register where doctor=?";
		int i = 0;
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, doctor);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				i++;
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return i;
	}
	public String find5() {
		// TODO Auto-generated method stub
		register Register = new register();
		Connection con = null;
		String sql = "select * from db2.patient";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			ResultSet rs = stem.executeQuery();
/*			while(rs.next()){
				i++;
			}*/
			while(rs.next()){
				Register.setId(rs.getInt("Id"));
				Register.setName(rs.getString("name"));
				Register.setDoctor(rs.getString("doctor"));
				Register.setSubject(rs.getString("subject"));
				return null;
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
		
	}
	public String find6bydoctor(String doctor) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "select * from db2.register where doctor=?";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, doctor);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				return rs.getString("name");
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
}
