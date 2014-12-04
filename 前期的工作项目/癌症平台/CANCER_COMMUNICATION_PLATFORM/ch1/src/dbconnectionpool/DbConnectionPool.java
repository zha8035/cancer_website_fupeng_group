package dbconnectionpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

public class DbConnectionPool {
	private static BasicDataSource dataSource = null;
	public DbConnectionPool(){
	
	}
	//��ʼ�����ӳ�
	public static void init(){
		if(dataSource != null){
			try{
				dataSource.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			dataSource = null;
		}
		//ʹ��properties���������ݿ����ӳ���Ϣ
		try{
			Properties p = new Properties();
			p.setProperty("driverClassName", "com.mysql.jdbc.Driver");
			p.setProperty("url", "jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=UTF-8");
			p.setProperty("username","root");
			p.setProperty("password", "123ljf");
			p.setProperty("maxActive", "5");
			p.setProperty("maxIdle", "2");
			p.setProperty("maxWait","60000");
			p.setProperty("removeAbandloned", "false");
			p.setProperty("removeAbandonedTimeout", "120");
			p.setProperty("testOnBorrow","true");
			p.setProperty("logAbandoned", "true");
			dataSource = (BasicDataSource)BasicDataSourceFactory.createDataSource(p);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//�����ӳ��л�ȡ����
	public static synchronized Connection getConnection() throws SQLException{
		if(dataSource == null){
			init();
		}
		Connection con = null;
		if(dataSource != null){
			con = dataSource.getConnection();
		}
		return con;		
	}
}
