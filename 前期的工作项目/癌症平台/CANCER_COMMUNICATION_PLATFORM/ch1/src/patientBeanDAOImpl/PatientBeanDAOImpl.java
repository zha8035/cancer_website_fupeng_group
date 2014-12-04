package patientBeanDAOImpl;

import java.sql.*;

import dbconnectionpool.DbConnectionPool;
import patientBean.PatientBean;
import patientBeanDAO.PatientBeanDAO;

public class PatientBeanDAOImpl implements PatientBeanDAO{

	@Override
	public void save(PatientBean patientbean) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "insert into db1.patient(nickname,name,password,pwpassword,sex,"
				+ "age,work,city,subject,tel,email) values(?,?,?,?,?,?,?,?,?,?,?)";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, patientbean.getNickname());
			stem.setString(2, patientbean.getName());
			stem.setString(3, patientbean.getPassword());
			stem.setString(4, patientbean.getPwpassword());
			stem.setString(5, patientbean.getSex());
			stem.setInt(6, patientbean.getAge());
			stem.setString(7, patientbean.getWork());
			stem.setString(8, patientbean.getCity());
			stem.setString(9, patientbean.getSubject());
			stem.setString(10, patientbean.getTel());
			stem.setString(11, patientbean.getEmail());
			stem.executeUpdate();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(PatientBean patientbean) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "delete from db1.patient where id=?";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setInt(1, patientbean.getId());
			stem.executeUpdate();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(PatientBean patientbean) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "insert into dbq.patient(nickname,name,password,pwpassword,sex,"
				+ "age,work,city,subject,tel,email) values(?,?,?,?,?,?,?,?,?,?,?)";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, patientbean.getNickname());
			stem.setString(2, patientbean.getName());
			stem.setString(3, patientbean.getPassword());
			stem.setString(4, patientbean.getPwpassword());
			stem.setString(5, patientbean.getSex());
			stem.setInt(6, patientbean.getAge());
			stem.setString(7, patientbean.getWork());
			stem.setString(8, patientbean.getCity());
			stem.setString(9, patientbean.getSubject());
			stem.setString(10, patientbean.getTel());
			stem.setString(11, patientbean.getEmail());
			stem.executeUpdate();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public PatientBean searchBynickname(String nickname) {
		// TODO Auto-generated method stub
		PatientBean patientbean = new PatientBean();
		Connection con = null;
		String sql = "select * from db1.patient where nickname=?";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, nickname);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				patientbean.setNickname(rs.getString("nickname"));
				patientbean.setName(rs.getString("name"));
				patientbean.setPassword(rs.getString("password"));
				patientbean.setAge(rs.getInt("age"));
				patientbean.setSex(rs.getString("sex"));
				patientbean.setWork(rs.getString("work"));
				patientbean.setCity(rs.getString("city"));
				patientbean.setSubject(rs.getString("subject"));
				patientbean.setTel(rs.getString("tel"));
				patientbean.setEmail(rs.getString("email"));
			}
/*			else{
				System.out.print("no data");
			}*/
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return patientbean;
	}
	@Override
	public PatientBean searchByname(String name) {
		// TODO Auto-generated method stub
		PatientBean patientbean = new PatientBean();
		Connection con = null;
		String sql = "select * from db1.patient where name=?";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, name);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				patientbean.setNickname(rs.getString("nickname"));
				patientbean.setName(rs.getString("name"));
				patientbean.setPassword(rs.getString("password"));
				patientbean.setAge(rs.getInt("age"));
				patientbean.setSex(rs.getString("sex"));
				patientbean.setWork(rs.getString("work"));
				patientbean.setCity(rs.getString("city"));
				patientbean.setSubject(rs.getString("subject"));
				patientbean.setTel(rs.getString("tel"));
				patientbean.setEmail(rs.getString("email"));
			}
/*			else{
				System.out.print("no data");
			}*/
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return patientbean;
	}

	@Override
	public PatientBean searchBysubject(String subject) {
		// TODO Auto-generated method stub
		PatientBean patientbean = new PatientBean();
		Connection con = null;
	    String sql = "select from db1.doctor where subject=?";
	    try{
	    	con = DbConnectionPool.getConnection();
	    	PreparedStatement stem = con.prepareStatement(sql);
	    	stem.setString(1, subject);
	    	ResultSet rs = stem.executeQuery();
	    	if(rs.next()){
				patientbean.setNickname(rs.getString("nickname"));
				patientbean.setName(rs.getString("name"));
				patientbean.setPassword(rs.getString("password"));
				patientbean.setAge(rs.getInt("age"));
				patientbean.setSex(rs.getString("sex"));
				patientbean.setWork(rs.getString("work"));
				patientbean.setCity(rs.getString("city"));
				patientbean.setSubject(rs.getString("subject"));
				patientbean.setTel(rs.getString("tel"));
				patientbean.setEmail(rs.getString("email"));		
	    	}
	    	rs.close();
	    	stem.close();
	    	con.close();
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
		return patientbean;
	}

}
