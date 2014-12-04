package pdtableDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnectPool.DBConnectPool;
import pdtableDAO.PDtableDAO;

public class PDtableDAOImpl implements PDtableDAO{
	
	public int findByname1(String name){
		int i =0;
		Connection con = null;
		String sql = "select doctorname from db2.pdtable where subjectname=?";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, name);
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


	public void Save(String subject, String doctorname) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "insert  into db2.pdtable(subjectname,doctorname) value(?,?)";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, subject);
			stem.setString(2, doctorname);
			stem.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	public String findByname2(String name, int m, int n) {
		// TODO Auto-generated method stub
		Connection con = null;
		String s[] = new String[m];
		int i= 0;
		String sql = "select * from db2.pdtable where subjectname=?";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, name);
			ResultSet rs = stem.executeQuery();
			while(rs.next()){
				s[i] = rs.getString("doctorname");
				i++;

			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return s[n];
	}
}