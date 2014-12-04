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
	//初始化连接池
	public static void init(){
		if(dataSource != null){
			try{
				dataSource.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			dataSource = null;
		}
		//使用properties对象定义数据库连接池信息
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
	//从连接池中获取数据
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
