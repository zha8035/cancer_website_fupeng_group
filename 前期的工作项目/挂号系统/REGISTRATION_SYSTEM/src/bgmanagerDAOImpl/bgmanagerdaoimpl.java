package bgmanagerDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnectPool.DBConnectPool;

import bgmanager.BGM;
import bgmanagerDAO.BGmanagerDAO;

public class bgmanagerdaoimpl implements BGmanagerDAO{

	public void changepassword(String password) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql ="update db2.manager set password=?";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, password);
			stem.executeUpdate();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void save(BGM bgm) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "insert into db2.manager(name,sex,password,pwpassword) value(?,?,?,?)";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, bgm.getName());
			stem.setString(2, bgm.getSex());
			stem.setString(3, bgm.getPassword());
			stem.setString(4, bgm.getPwpassword());
			stem.executeUpdate();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public String findBypassword() {
		// TODO Auto-generated method stub
		Connection con = null;
		BGM bgm = new BGM();
		String sql = "select * from db2.manager";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				bgm.setPassword(rs.getString("password"));
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return bgm.getPassword();
	}

	public String findByname(String name) {
		// TODO Auto-generated method stub
		Connection con = null;
		BGM bgm = new BGM();
		String sql = "select password from db2.manager where name=?";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, name);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				bgm.setPassword(rs.getString("password"));
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return bgm.getPassword();
	}
	
}
