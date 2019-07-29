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

/**
 * Servlet implementation class engineerLoginSrv
 */
@WebServlet("/engineerLoginSrv")
public class engineerLoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public engineerLoginSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enggMail = request.getParameter("email").trim();
		String enggPassword = request.getParameter("pass").trim();
		
		EnggDao engg = new EnggDaoImpl();
		
		String page="engineerHome.jsp";
		
		HttpSession ses=request.getSession();
		int enggId=engg.idByEnggMail(enggMail);
		
		ses.setAttribute("flag", "invalid");
		ses.setAttribute("enggId", enggId);
		ses.setAttribute("name", engg.getEnggDetails(enggId).getenggName());
		
		if(engg.validateEngg(enggMail,enggPassword))
			page="enggWorkspace.jsp";
		
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
