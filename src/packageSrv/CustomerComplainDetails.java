package packageSrv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw_sw.dao.ComplainDao;
import com.hw_sw.dao.ComplainDaoImpl;

import beanPack.ComplainBean;

/**
 * Servlet implementation class CustomerComplainDetails
 */
@WebServlet("/CustomerComplainDetails")
public class CustomerComplainDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerComplainDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses=request.getSession();
		ComplainDao cDao=new ComplainDaoImpl();
		int id=(Integer)ses.getAttribute("customerId");
		ArrayList<ComplainBean> list=cDao.getComplainPerCustomer(id);
		ses.setAttribute("complainList", list);
		response.sendRedirect("customerComplain.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
