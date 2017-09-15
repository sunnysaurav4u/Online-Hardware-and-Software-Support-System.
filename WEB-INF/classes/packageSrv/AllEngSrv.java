package packageSrv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanPack.EnggBean;

import com.hw_sw.dao.EnggDao;
import com.hw_sw.dao.EnggDaoImpl;

/**
 * Servlet implementation class AllEngSrv
 */
@WebServlet("/AllEngSrv")
public class AllEngSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllEngSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		EnggDao dao=new EnggDaoImpl();
		
		ArrayList<EnggBean> elist=dao.getAllEngineerDetails();
		if(elist != null)
			request.getSession().setAttribute("eng_list", elist);
		
		response.sendRedirect("allEngDetails.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
