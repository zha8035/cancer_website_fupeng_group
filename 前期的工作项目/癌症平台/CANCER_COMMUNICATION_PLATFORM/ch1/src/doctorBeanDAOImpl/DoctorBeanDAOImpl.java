package doctorBeanDAOImpl;

import java.sql.*;
import java.sql.SQLException;

import dbconnectionpool.DbConnectionPool;
import doctorBean.DoctorBean;
import doctorBeanDAO.DoctorBeanDAO;

public class DoctorBeanDAOImpl implements DoctorBeanDAO{


	@Override
	public void save(DoctorBean doctorbean) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "insert into db1.doctor(nickname,name,password,pwpassword,sex,"
				+ "age,city,hospital,subject,position,tel,email) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	    try{
	    	con = DbConnectionPool.getConnection();
	    	PreparedStatement stem = con.prepareStatement(sql);
	    	stem.setString(1,doctorbean.getNickname());
	    	stem.setString(2,doctorbean.getName());
	    	stem.setString(3,doctorbean.getPassword());
	    	stem.setString(4,doctorbean.getPwpassword());
	    	stem.setString(5,doctorbean.getSex());
	    	//stem.setCharacterStream(4,doctorbean.getSex());
	    	stem.setInt(6,doctorbean.getAge());
	    	stem.setString(7,doctorbean.getCity());
	    	stem.setString(8,doctorbean.getHospital());
	    	stem.setString(9,doctorbean.getSubject());
	    	stem.setString(10,doctorbean.getPosition());
	    	stem.setString(11,doctorbean.getTel());
	    	stem.setString(12,doctorbean.getEmail());
	    	stem.executeUpdate();
	    	stem.close();
	    	con.close();
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
	}

	@Override
	public void delete(DoctorBean doctorbean) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "delete from db1.doctor where id= ?";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setInt(1,doctorbean.getId());
			stem.executeUpdate();
			stem.close();
			con.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(DoctorBean doctorbean) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "update db1.doctor set name=?,password=?,pwpassword=?,sex=?,age=?,subject=?,position=?,tel=?,email=?";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, doctorbean.getNickname());
			stem.setString(2, doctorbean.getName());
			stem.setString(3,doctorbean.getPassword());
			stem.setString(4,doctorbean.getPwpassword());
			stem.setString(5, doctorbean.getSex());
			stem.setInt(6,doctorbean.getAge());
			stem.setString(7, doctorbean.getCity());
			stem.setString(8, doctorbean.getHospital());
			stem.setString(9,doctorbean.getSubject());
			stem.setString(10, doctorbean.getPosition());
			stem.setString(11, doctorbean.getTel());
			stem.setString(12, doctorbean.getEmail());
			stem.executeUpdate();
			stem.close();
			con.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public DoctorBean searchBynickname(String nickname) {
		// TODO Auto-generated method stub
		DoctorBean doctorbean = new DoctorBean(); 
		Connection con =null;
		String sql="select * from db1.doctor where nickname=?";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1,nickname);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				doctorbean.setId(rs.getInt("Id"));
				doctorbean.setName(rs.getString("nickname"));
				doctorbean.setName(rs.getString("name"));
				doctorbean.setPassword(rs.getString("password"));
				doctorbean.setPwpassword(rs.getString("pwpassword"));
				doctorbean.setSex(rs.getString("sex"));
				doctorbean.setAge(rs.getInt("age"));
				doctorbean.setCity(rs.getString("city"));
				doctorbean.setHospital(rs.getString("hospital"));
				doctorbean.setSubject(rs.getString("subject"));
				doctorbean.setPosition(rs.getString("position"));
				doctorbean.setTel(rs.getString("tel"));
				doctorbean.setEmail(rs.getString("email"));
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return doctorbean;
	}
	
	@Override
	public DoctorBean searchByname(String name) {
		// TODO Auto-generated method stub
		DoctorBean doctorbean = new DoctorBean(); 
		Connection con =null;
		String sql="select * from db1.doctor where name=?";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1,name);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				doctorbean.setId(rs.getInt("Id"));
				doctorbean.setName(rs.getString("nickname"));
				doctorbean.setName(rs.getString("name"));
				doctorbean.setPassword(rs.getString("password"));
				doctorbean.setPwpassword(rs.getString("pwpassword"));
				doctorbean.setSex(rs.getString("sex"));
				doctorbean.setAge(rs.getInt("age"));
				doctorbean.setCity(rs.getString("city"));
				doctorbean.setHospital(rs.getString("hospital"));
				doctorbean.setSubject(rs.getString("subject"));
				doctorbean.setPosition(rs.getString("position"));
				doctorbean.setTel(rs.getString("tel"));
				doctorbean.setEmail(rs.getString("email"));
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return doctorbean;
	}

	@Override
	public DoctorBean searchBysubject(String subject) {
		// TODO Auto-generated method stub
		DoctorBean doctorbean = new DoctorBean(); 
		Connection con = null;
		String sql = "select from db1.doctor where subject=?";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1,subject);
			ResultSet rs = stem.executeQuery();
			if(rs != null){
				rs.first();
				doctorbean.setId(rs.getInt("Id"));
				doctorbean.setName(rs.getString("nickname"));
				doctorbean.setName(rs.getString("name"));
				doctorbean.setPassword(rs.getString("password"));
				doctorbean.setPwpassword(rs.getString("pwpassword"));
				doctorbean.setSex(rs.getString("sex"));
				doctorbean.setAge(rs.getInt("age"));
				doctorbean.setCity(rs.getString("city"));
				doctorbean.setHospital(rs.getString("hospital"));
				doctorbean.setSubject(rs.getString("subject"));
				doctorbean.setPosition(rs.getString("position"));
				doctorbean.setTel(rs.getString("tel"));
				doctorbean.setEmail(rs.getString("email"));
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return doctorbean;
	}

	@Override
	public DoctorBean searchByposition(String position) {
		// TODO Auto-generated method stub
		DoctorBean doctorbean = new DoctorBean(); 
		Connection con = null;
		String sql="select from db1.doctor where position=?";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
		    stem.setString(1,position);
		    ResultSet rs = stem.executeQuery();
		    if(rs.next()){
				doctorbean.setId(rs.getInt("Id"));
				doctorbean.setName(rs.getString("nickname"));
				doctorbean.setName(rs.getString("name"));
				doctorbean.setPassword(rs.getString("password"));
				doctorbean.setPwpassword(rs.getString("pwpassword"));
				doctorbean.setSex(rs.getString("sex"));
				doctorbean.setAge(rs.getInt("age"));
				doctorbean.setCity(rs.getString("city"));
				doctorbean.setHospital(rs.getString("hospital"));
				doctorbean.setSubject(rs.getString("subject"));
				doctorbean.setPosition(rs.getString("position"));
				doctorbean.setTel(rs.getString("tel"));
				doctorbean.setEmail(rs.getString("email"));
		    }
		    rs.close();
		    stem.close();
		    con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return doctorbean;
	}
}
