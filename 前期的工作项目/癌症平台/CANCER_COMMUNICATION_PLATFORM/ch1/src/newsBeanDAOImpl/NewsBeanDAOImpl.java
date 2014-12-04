package newsBeanDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbconnectionpool.DbConnectionPool;
import newsBean.NewsBean;
import newsBeanDAO.NewsBeanDAO;

public class NewsBeanDAOImpl implements NewsBeanDAO{

	@Override
	public void save(NewsBean newsbean) {
		// TODO Auto-generated method stub
/*		NewsBean newsBean = new NewsBean();*/
		Connection con = null;
		String sql = "insert into db1.news(title,author,time,content) values(?,?,?,?)";
		try{
			con = DbConnectionPool.getConnection();
			PreparedStatement stem = con.prepareStatement(sql);
			stem.setString(1, newsbean.getTitle());
			stem.setString(2, newsbean.getAuthor());
			stem.setDate(3, newsbean.getTime());
			stem.setString(4, newsbean.getContent());
			stem.executeUpdate();
			stem.close();
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
/*		return newsBean;*/
	}
}
