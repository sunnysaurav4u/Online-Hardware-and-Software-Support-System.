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

/**
 * Servlet implementation class ComplainStatusById
 */
@WebServlet("/ComplainStatusById")
public class ComplainStatusById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainStatusById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id=Integer.parseInt(request.getParameter("complainId").trim());
		ComplainDao cDao=new ComplainDaoImpl();
		String status=cDao.checkComplainStatus(id);
		
		HttpSession ses=request.getSession();
		String tmp = "temp";
		ses.setAttribute("temp", tmp);
		ses.setAttribute("Complainstatus", status);
		response.sendRedirect("complainStatusById.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
