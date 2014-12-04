package doctorRegisterActionServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import doctorBean.DoctorBean;
import doctorBeanDAOImpl.DoctorBeanDAOImpl;

/**
 * Servlet implementation class DoctorRegisterActionServlet
 */
@WebServlet("/DoctorRegisterActionServlet")
public class DoctorRegisterActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorRegisterActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DoctorBean doctorbean = new DoctorBean();
/*		req.setCharacterEncoding("UTF-8");*/
		doctorbean.setNickname(req.getParameter("nickname"));
		doctorbean.setName(req.getParameter("name"));
		doctorbean.setPassword(req.getParameter("password"));
		doctorbean.setPwpassword(req.getParameter("pwpassword"));
		doctorbean.setSex(req.getParameter("sex"));
		try{
			doctorbean.setAge(Integer.parseInt(req.getParameter("age")));
		}catch(NumberFormatException e){}
		doctorbean.setCity(req.getParameter("city"));
		doctorbean.setHospital(req.getParameter("hospital"));
		doctorbean.setSubject(req.getParameter("subject"));
		doctorbean.setPosition(req.getParameter("position"));
		doctorbean.setTel(req.getParameter("tel"));
		doctorbean.setEmail(req.getParameter("email"));
		
		DoctorBeanDAOImpl doctorbeandaoimpl = new DoctorBeanDAOImpl();
		doctorbeandaoimpl.save(doctorbean);
		HttpSession session = req.getSession(true);
		session.setAttribute("DoctorBean",doctorbean);
		resp.sendRedirect("doctor.jsp");

	}

}
