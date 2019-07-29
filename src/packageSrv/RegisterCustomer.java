package packageSrv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw_sw.dao.CustomerDao;
import com.hw_sw.dao.CustomerDaoImpl;

import beanPack.CustomerBean;

/**
 * Servlet implementation class RegisterCustomer
 */
@WebServlet("/RegisterCustomer")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String mobile = request.getParameter("mobile").trim();
		String city = request.getParameter("city").trim();
		String pass = request.getParameter("pass").trim();
		
		String page="registerCustomer.jsp";
		
		HttpSession ses=request.getSession();
		ses.setAttribute("flag", "valid");
		
		CustomerBean cb = new CustomerBean();
		cb.setCustomerName(name);
		cb.setCustomerMail(email);
		cb.setCustomerMobile(mobile);
		cb.setCustomerCity(city);
		cb.setCustomerPassword(pass);
		
		CustomerDao customer = new CustomerDaoImpl();
		int customerId=customer.addCustomer(cb);
		
		if(customerId>0)
			ses.setAttribute("id",customerId);
			response.sendRedirect(page);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
