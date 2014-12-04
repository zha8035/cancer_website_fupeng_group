package dbConnectPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBConnectPool { 
	private static BasicDataSource dataSource = null;
	public DBConnectPool(){
	}
	public static void init(){
		if(dataSource != null){
			try{
				dataSource.close();;
			}catch(Exception e){
				e.printStackTrace();
			}
			dataSource = null;
		}
		try{
			Properties  p = new Properties();
			p.setProperty("driverClassName", "com.mysql.jdbc.Driver");
			p.setProperty("url", "jdbc:mysql://localhost/db2");
			p.setProperty("username", "root");
			p.setProperty("password", "123ljf");
			p.setProperty("maxActive", "30");
			p.setProperty("maxIdle", "10");
			p.setProperty("maxWait", "1000");
			p.setProperty("removeAbandoned", "false");
			p.setProperty("removeAbandonedTimeout", "120");
			p.setProperty("testOnBorrow", "true");
			p.setProperty("logAbandoned", "true");
			dataSource = (BasicDataSource)BasicDataSourceFactory.createDataSource(p);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
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
