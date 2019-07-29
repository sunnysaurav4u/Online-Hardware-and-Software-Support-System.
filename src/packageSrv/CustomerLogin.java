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
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDao customer = new CustomerDaoImpl();
		String mail = request.getParameter("mail").trim();
		String pass = request.getParameter("pass").trim();
		
		String page="customerHome.jsp";
		
		HttpSession ses=request.getSession();
		int customerId=customer.idByCustomerName(mail);
		
		ses.setAttribute("flag", "invalid");
		
		if(customerId>0) {
			ses.setAttribute("customerId", customerId);
			ses.setAttribute("name", (customer.viewCustomerById(customerId)).getCustomerName());
		}
		if(customer.validateCustomer(mail,pass))
			page="registerComplaint.jsp";
		
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
