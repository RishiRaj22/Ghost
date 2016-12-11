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
 * Servlet implementation class Output
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
    	SecurityUtils security=new SecurityUtils();
		auth=security.getAuthencticity(request, response);
		if(auth)
		{
		response.setContentType("text/html");
		out.append("<title>Output Page</title>");
		out.append("<meta name=\"viewport\" content=\"width=device-width, initial-sclae=1\">");
		try {
			CommandExec.runApp(request.getParameter("command"));
			out.append("<h1>Command "+request.getParameter("command")+" ran successfully</h1>");
			out.append("<img src=\"img/nyan.gif\">");
			AddItems.getTable(request, response);
		} catch (CommandExecException e) {
			out.write("<h1>Error</h1> Command  "+request.getParameter("command")+" unable to execute.");
			out.append("<img src=\"img/error.jpg\">");
			e.printStackTrace();
		}
		finally{
			out.append("</br>Go back to <a href=\"Command\">homepage</a>");
		}
		}
		else SecurityUtils.askPassword(response);

	}
    


}
