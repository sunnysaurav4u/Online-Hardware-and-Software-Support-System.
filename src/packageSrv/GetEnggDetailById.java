package packageSrv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;

import com.hw_sw.dao.EnggDao;
import com.hw_sw.dao.EnggDaoImpl;

import beanPack.EnggBean;

/**
 * Servlet implementation class GetEnggDetailById
 */
@WebServlet("/GetEnggDetailById")
public class GetEnggDetailById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEnggDetailById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("enggid").trim());
		EnggDao engg=new EnggDaoImpl();
		EnggBean ebean=engg.getEnggDetails(id);
		/*String name=ebean.getenggName();
		String mail=ebean.getenggMail();
		String mobile=ebean.getenggMobile();
		String password=ebean.getEnggPassword();*/
		HttpSession ses=request.getSession();
		//ses.setAttribute("beanobj", ebean);
		String tmp = "temp";
		ses.setAttribute("temp", tmp);
		if(ebean != null)
			ses.setAttribute("enggBeanObj",ebean);
			response.sendRedirect("viewEnggById.jsp");
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
