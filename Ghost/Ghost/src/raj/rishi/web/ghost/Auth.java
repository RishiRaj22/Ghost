package raj.rishi.web.ghost;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import raj.rishi.web.ghost.utils.Constants;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("pass").equals(Constants.PASSWORD))
		{
			System.out.println(request.getParameter("checkbox"));
			if(request.getParameter("remember")!=null)
			{
			Cookie cookie=new Cookie("IsAuthenticated",Constants.COOKIE_VALUE);
			cookie.setMaxAge(60*60*24*365);
			response.addCookie(cookie);
			}
			request.getSession().setAttribute("auth", Constants.SESSION_AUTHENTICATION);
			
			response.sendRedirect("Command");
		}
		else
			response.getWriter().append("Incorrect Password");
	}

}
