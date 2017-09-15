package packageSrv;

import java.io.IOException;

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
 * Servlet implementation class SrvComplainDetailByid
 */
@WebServlet("/SrvComplainDetailByid")
public class SrvComplainDetailByid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrvComplainDetailByid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int complainId=Integer.parseInt(request.getParameter("complainId").trim());
		ComplainDao complain=new ComplainDaoImpl();
		ComplainBean cbean=complain.getComplain(complainId);
		HttpSession ses=request.getSession();
		String tmp = "temp";
		ses.setAttribute("temp", tmp);
		if(cbean != null){
			ses.setAttribute("complainBeanObj", cbean);
		response.sendRedirect("complainDetailById.jsp");
			
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
