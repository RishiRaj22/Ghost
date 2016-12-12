package raj.rishi.web.ghost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import raj.rishi.web.ghost.backend.AddItems;
import raj.rishi.web.ghost.backend.CommandExec;
import raj.rishi.web.ghost.utils.CommandExecException;
import raj.rishi.web.ghost.utils.SecurityUtils;

/**
 * @author Raj
 * A servlet for running output and showing the result to the client.
 */
@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean auth=false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Output() {
        super();
        
    }

	/**
	 * This is the Servlet that will show the result of the command run along with the list of various commands.
	 * It first checks for the authentication of the user,then runs the requested command on the server
	 * using normal JAVA class CommandExec{@link raj.rishi.web.ghost.backend.CommandExec#runApp(String)}.
	 * It finally adds the various commands from the datasource{@link raj.rishi.web.ghost.backend.AddItems#getList(HttpServletRequest, HttpServletResponse)}
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
    	SecurityUtils security=new SecurityUtils();
		auth=security.getAuthencticity(request);
		if(auth)
		{
		response.setContentType("text/html");
		out.append("<title>Output Page</title>");
		out.append("<meta name=\"viewport\" content=\"width=device-width, initial-sclae=1\">");
		try {
			CommandExec.runApp(request.getParameter("command"));
			out.append("<h1>Command "+request.getParameter("command")+" ran successfully</h1>");
			out.append("<img src=\"img/nyan.gif\">");//You may remove or change the successs image as per your wish
		} catch (CommandExecException e) {
			out.write("<h1>Error</h1> Command  "+request.getParameter("command")+" unable to execute.");
			out.append("<img src=\"img/error.jpg\">");//You may remove or change the error image as per your wish
			e.printStackTrace();
		}
		finally{
			AddItems.getList(request, response);
			out.append("</br>Go back to <a href=\"Command\">homepage</a>");
		}
		}
		else SecurityUtils.askPassword(response);

	}
    


}
