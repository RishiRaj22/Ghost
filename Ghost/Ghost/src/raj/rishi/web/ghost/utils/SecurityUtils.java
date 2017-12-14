package raj.rishi.web.ghost.utils;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/** This class is used to check the authenticity of a user and ask them the password
 */
public class SecurityUtils {
	/**
	 * This method is used to write in the response, HTML code to ask the user for password.
	 * @param response
	 * @throws IOException
	 */
	public static void askPassword(HttpServletResponse response) throws IOException
	{
		response.getWriter().write("<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></head><title>Ghost: Welcome</title><h1>Please type the password to access</h1><form  action=\"Auth\" method=\"post\">Password: <input type=\"password\" name=\"pass\"></input><br>Remember me<input type=checkbox name=\"remember\" value=\"y\"></input><br><input type=\"submit\"></input></form> </html>");
	}
	/**
	 * This method is used to check wether a user is authenticated 
	 * by checking the session parameters and cookies stored on the client's machine,
	 * @param request Used to access cookies, session of the given reuest to get authenticity of user
	 * @return Whether the user is authentic or not
	 * @throws IOException
	 */
	public boolean getAuthencticity(HttpServletRequest request) throws IOException {
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
