package patientDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConnectPool.DBConnectPool;
import patient.PatientInfo;
import patientDAO.PatientDAO;

public class PatientDAOImpl implements PatientDAO{
	
	public void Save(PatientInfo patientInfo) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "insert into db2.patient(name,age,sex,Idcard,address,"
				+ "subject,doctor) values(?,?,?,?,?,?,?)";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, patientInfo.getName());
			stem.setInt(2, patientInfo.getAge());
			stem.setString(3, patientInfo.getSex());
			stem.setString(4, patientInfo.getIdcard());
			stem.setString(5, patientInfo.getAddress());
			stem.setString(6, patientInfo.getSubject());
			stem.setString(7, patientInfo.getDoctor());
			stem.executeUpdate();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public PatientInfo findByname(String nametext){
		PatientInfo patientinfo = new PatientInfo();
/*		int i =0;*/
/*		patientinfo = null;*/
/*		PatientInfo patientinfo = null;*/
		Connection con = null;
		String sql = "select * from db2.patient where name=?";
		try{
			con = DBConnectPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, nametext);
			ResultSet rs = stem.executeQuery();
/*			while(rs.next()){
				i++;
			}*/
			while(rs.next()){
				patientinfo.setId(rs.getInt("Id"));
				patientinfo.setName(rs.getString("name"));
				try{
					patientinfo.setAge(Integer.parseInt(rs.getString("age")));
				}catch(NumberFormatException e){
					e.printStackTrace();
				}
				patientinfo.setSex(rs.getString("sex"));
				patientinfo.setAddress(rs.getString("address"));
				patientinfo.setIdcard(rs.getString("Idcard"));
				patientinfo.setDoctor(rs.getString("doctor"));
				patientinfo.setSubject(rs.getString("subject"));
			}
			rs.close();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return patientinfo;
		
	}
	

}
