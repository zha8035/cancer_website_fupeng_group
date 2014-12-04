package confirmPInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import patientBean.PatientBean;
import patientBeanDAOImpl.PatientBeanDAOImpl;

/**
 * Servlet implementation class ConfirmPInfo
 */
@WebServlet("/ConfirmPInfo")
public class ConfirmPInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmPInfo() {
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
		PatientBean patientbean = new PatientBean();
		PatientBeanDAOImpl patientbeandaoimpl = new PatientBeanDAOImpl();
		patientbean = patientbeandaoimpl.searchByname(request.getParameter("name"));
		if(request.getParameter("password").equals(patientbean.getPassword())){
			HttpSession session = request.getSession(true);
			session.setAttribute("username",request.getParameter("name"));
			response.sendRedirect("patienthomepage/patientmain.jsp");
		}
		else{
			response.sendRedirect("patient.jsp");
		}
	}

}
