package patientRegisterActionServlet;

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
 * Servlet implementation class PatientRegisterActionServlet
 */
@WebServlet("/PatientRegisterActionServlet")
public class PatientRegisterActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRegisterActionServlet() {
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
		
		patientbean.setNickname(request.getParameter("nickname"));
		patientbean.setName(request.getParameter("name"));
		patientbean.setPassword(request.getParameter("password"));
		patientbean.setPwpassword(request.getParameter("pwpassword"));
		try{
			patientbean.setAge(Integer.parseInt(request.getParameter("age")));
		}catch(NumberFormatException e){}
		patientbean.setSex(request.getParameter("sex"));
		patientbean.setWork(request.getParameter("work"));
		patientbean.setCity(request.getParameter("city"));
		patientbean.setSubject(request.getParameter("subject"));
		patientbean.setTel(request.getParameter("tel"));
		patientbean.setEmail(request.getParameter("email"));
		
		patientbeandaoimpl.save(patientbean);
		HttpSession session = request.getSession(true);
		session.setAttribute("PatientBean", patientbean);
		response.sendRedirect("patient.jsp");
	}

}
