import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Loginpage
 */
@WebServlet("/Loginpage")
public class Loginpage extends HttpServlet {
	Map<String, String> obj;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Loginpage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String upwd = req.getParameter("upwd");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		obj = new HashMap<String, String>();
		obj.put("Bob", "bob123@");
		obj.put("Max", "max234@");
		obj.put("John", "john345@");
		obj.put("Tom", "tom456@");
		if (!authenticate(uname, upwd)) {
			out.println("<h2>" + "Invalid User!..Please Try Again</h2>");
			return;
		}else {
		session.setAttribute("uname", uname);
		
		res.sendRedirect("Dashboard");
		}
	}

	protected boolean authenticate(String inputname, String inputpwd) {
		// TODO Auto-generated method stub
		boolean valid = false;
		if (obj.get(inputname) != null) {
			valid = obj.get(inputname).equals(inputpwd);
		}
		return valid;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
