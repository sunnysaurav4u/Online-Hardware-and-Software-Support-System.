package packageSrv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hw_sw.dao.ComplainDao;
import com.hw_sw.dao.ComplainDaoImpl;

/**
 * Servlet implementation class submitAnswer
 */
@WebServlet("/submitAnswer")
public class submitAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int complainId = Integer.parseInt(request.getParameter("complainId").trim());
		String answer = request.getParameter("answer");
		
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html"); 
		
		ComplainDao dao = new ComplainDaoImpl();
		if(dao.answerComplain(complainId, answer)) {
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Answer Submitted');"); 
			out.println("window.location = 'enggWorkspace.jsp'");
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
