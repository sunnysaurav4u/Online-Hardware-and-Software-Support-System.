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
 * Servlet implementation class AssignComplain
 */
@WebServlet("/AssignComplain")
public class AssignComplain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignComplain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ComplainDao cDao=new ComplainDaoImpl();
		ArrayList<ComplainBean> c_list=cDao.getAllComplainDetais();
		
		HttpSession ses=request.getSession();
		if(c_list != null)
			ses.setAttribute("complainList", c_list);
		response.sendRedirect("AllcomplainDeatails.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
