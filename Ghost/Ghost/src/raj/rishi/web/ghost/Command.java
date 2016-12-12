package raj.rishi.web.ghost;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import raj.rishi.web.ghost.backend.AddItems;
import raj.rishi.web.ghost.utils.SecurityUtils;

/**
 * A servlet for welcoming the user with a list of commands and terminal or password screen if or not a user is authenticated. 
 */
@WebServlet("/Command")
public class Command extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private boolean auth;
    public Command() {
        super();
      
    }

	/**
	 * If user is not authenticated, then a password is asked,.
	 * Else, an input is given to type a command and a list of commands from your data source of
	 * choice{@link raj.rishi.web.ghost.backend.AddItems#getList(HttpServletRequest, HttpServletResponse)}
	 * is given.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			SecurityUtils security=new SecurityUtils();
			PrintWriter out=response.getWriter();
			auth=security.getAuthencticity(request);
			if(auth)
			{	
			response.setContentType("text/html");
			out.append("<title>Ghost</title>");
			out.append("<meta name=\"viewport\" content=\"width=device-width, initial-sclae=1\">");
			out.append("<h1>Welcome to P.C. Manipulating Ghost</h1>");
			AddItems.getList(request,response);
			
		}
			else SecurityUtils.askPassword(response);
		
		
	}





	


	
}
