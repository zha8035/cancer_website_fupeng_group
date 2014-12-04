package newspostServlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newsBean.NewsBean;
import newsBeanDAOImpl.NewsBeanDAOImpl;

/**
 * Servlet implementation class NewsPostServlet
 */
@WebServlet("/NewsPostServlet")
public class NewsPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		NewsBeanDAOImpl newsbeandaoimpl =new NewsBeanDAOImpl();
		Date date = new Date(0);
/*		SimpleDateFormat sdf = new SimpleDateFormat("Gyyyy 年 MMMd 日 E HH 时 mm 分 ss 秒 z");*/
/*		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date time = sdf.format(date);*/
		NewsBean newsbean = new NewsBean();
		newsbean.setTitle(request.getParameter("title"));
		newsbean.setAuthor(request.getParameter("author"));
		newsbean.setTime(date);
		newsbean.setContent(request.getParameter("content"));
		
		newsbeandaoimpl.save(newsbean);	
		HttpSession session = request.getSession();
		session.setAttribute("title", request.getParameter("title"));
		session.setAttribute("author", request.getParameter("author"));
		session.setAttribute("time", "time");
		session.setAttribute("content", request.getParameter("content"));
		response.sendRedirect("patienthomepage/patientmain.jsp");

	}

}
