package raj.rishi.web.ghost.utils;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityUtils {
	
	public static void askPassword(HttpServletResponse response) throws IOException
	{
		response.getWriter().write("<html><title>Ghost: Welcome</title><h1>Please type the password to access</h1><form  action=\"Auth\" method=\"post\">Password: <input type=\"password\" name=\"pass\"></input><br>Remember me<input type=checkbox name=\"remember\" value=\"y\"></input><br><input type=\"submit\"></input></form> </html>");
	}
	
	public boolean getAuthencticity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(request.getSession().getAttribute("auth")!=null&&request.getSession().getAttribute("auth").equals(Constants.SESSION_AUTHENTICATION))
			return true;
		Cookie[] cookies=request.getCookies();
		if(cookies==null) return false;
		for(int i=0;i<cookies.length;i++)
		{
			if(cookies[i].getName().equals("IsAuthenticated")&&cookies[i].getValue().equals(Constants.COOKIE_VALUE))
				return true;
		}
		return false;
	}

}
