package newsBean;

/*import java.sql.Connection;*/
import java.sql.Date;
/*import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbconnectionpool.DbConnectionPool;*/

public class NewsBean {
	private String title;
	private String author;
	private Date time;
	private String content;
/*	private StringBuffer stringbuffer;*/
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
/*	public StringBuffer getStringbuffer() {
			Connection con = null;
			String sql = "select * from db1.news order by time desc limit 5";
			try{
				con = DbConnectionPool.getConnection();
				PreparedStatement stem = con.prepareStatement(sql);
				ResultSet rs = stem.executeQuery();
				while(rs.next()){
					int id = rs.getInt("Id");
					String title = rs.getString("title");
					String author = rs.getString("author");
					Date time = rs.getDate("time");
					String content = rs.getString("content");
					stringbuffer.append("<tr>");
					stringbuffer.append("<td><a href=''?id="+id+"+title="+title+"<a/></td>");
					stringbuffer.append("<td>["+author+"</td>");
					stringbuffer.append("<td>["+time+"</td>");
					stringbuffer.append("</tr>");										
				}
				stem.close();
				con.close();
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return stringbuffer;
	}
	public void setStringbuffer(StringBuffer stringbuffer) {
		this.stringbuffer = stringbuffer;
	}*/
	
}
