package packageSrv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw_sw.dao.EnggDao;
import com.hw_sw.dao.EnggDaoImpl;

/**
 * Servlet implementation class ProcessComplainSrv
 */
@WebServlet("/ProcessComplainSrv")
public class ProcessComplainSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessComplainSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int complainId = Integer.parseInt(request.getParameter("complainId"));
		String enggMail = request.getParameter("enggMail");
		
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html"); 
		
		
		HttpSession ses = request.getSession();
		ses.setAttribute("flag", "invalid");
		
		EnggDao engg = new EnggDaoImpl();
		if(engg.assignComplainToEngg(complainId, enggMail)) {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Complain assigned to engineer');"); 
			out.println("window.location = 'admin.jsp'");
			out.println("</script>");
			
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
