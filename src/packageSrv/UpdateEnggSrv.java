package packageSrv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanPack.EnggBean;

import com.hw_sw.dao.EnggDao;
import com.hw_sw.dao.EnggDaoImpl;

/**
 * Servlet implementation class UpdateEnggSrv
 */
@WebServlet("/UpdateEnggSrv")
public class UpdateEnggSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEnggSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enggId=request.getParameter("enggId");
		String enggName=request.getParameter("enggName");
		String enggMail=request.getParameter("enggMail");
		String enggMobile=request.getParameter("enggMobile");
		String enggPass=request.getParameter("enggPass");
	
		
		int id=Integer.parseInt(enggId.trim());
		
		//System.out.println(id);		
		EnggBean ebean=new EnggBean(id, enggName, enggMail, enggMobile, enggPass);
	
		EnggDao dao=new EnggDaoImpl();
		
		 boolean f=dao.updateEngg(ebean);

	
	if(f){
		
		
		response.sendRedirect("allEngDetails.jsp");
	}
	else
		response.sendRedirect("updatefails.jsp");
	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
