package confirmDInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doctorBean.DoctorBean;
import doctorBeanDAOImpl.DoctorBeanDAOImpl;

/**
 * Servlet implementation class ConfirmDInfo
 */
@WebServlet("/ConfirmDInfo")
public class ConfirmDInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmDInfo() {
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
		DoctorBean doctorbean = new DoctorBean();
		DoctorBeanDAOImpl doctorbeandaoimpl = new DoctorBeanDAOImpl();
		doctorbean = doctorbeandaoimpl.searchByname(request.getParameter("name"));
		if(request.getParameter("password").equals(doctorbean.getPassword())){
			response.sendRedirect("doctorhomepage/doctormain.jsp");
		}
		else{
			response.sendRedirect("doctor.jsp");
		}
	}

}
