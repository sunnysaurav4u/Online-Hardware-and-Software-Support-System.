package packageSrv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw_sw.dao.EnggDao;
import com.hw_sw.dao.EnggDaoImpl;

import beanPack.EnggBean;

/**
 * Servlet implementation class AddEngg
 */
@WebServlet("/AddEngg")
public class AddEngg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEngg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("pass");
		
		EnggBean ebean=new EnggBean(0, name, email, mobile, password);
		EnggDao addenggineer=new EnggDaoImpl();
		
		int enggid=addenggineer.addEngg(ebean);
		HttpSession ses=request.getSession();
		ses.setAttribute("enggid", enggid);
		
		if(enggid>0)
			ses.setAttribute("id",enggid);
			response.sendRedirect("addEngg.jsp");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
