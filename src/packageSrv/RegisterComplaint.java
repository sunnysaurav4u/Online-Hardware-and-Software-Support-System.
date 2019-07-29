package packageSrv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;

import com.hw_sw.dao.ComplainDao;
import com.hw_sw.dao.ComplainDaoImpl;
import com.hw_sw.dao.CustomerDao;
import com.hw_sw.dao.CustomerDaoImpl;

import beanPack.ComplainBean;

/**
 * Servlet implementation class RegisterComplaint
 */
@WebServlet("/RegisterComplaint")
public class RegisterComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterComplaint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String complainName = request.getParameter("complainName");
		String complainType = request.getParameter("complainType");
		String complainDetail = request.getParameter("complain");
		
		
		
		HttpSession ses = request.getSession();
		
		int customerId=((Integer) ses.getAttribute("customerId")).intValue();
		
		ComplainBean cb = new ComplainBean();
		cb.setComplainName(complainName);
		cb.setComplainType(complainType);
		cb.setComplainDetail(complainDetail);
		cb.setCustomerId(customerId);
		
		ComplainDao customer = new ComplainDaoImpl();
		int complainId = customer.registerComplain(cb);
		
		if(complainId>0) {
			ses.setAttribute("id",complainId);
			ses.setAttribute("flag", "valid");
			response.sendRedirect("registerComplaint.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
