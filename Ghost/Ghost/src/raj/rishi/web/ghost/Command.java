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


@WebServlet("/Command")
public class Command extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private boolean auth;
    public Command() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			SecurityUtils security=new SecurityUtils();
			PrintWriter out=response.getWriter();
			auth=security.getAuthencticity(request, response);
			if(auth)
			{
				
			response.setContentType("text/html");
			out.append("<title>Ghost</title>");
			out.append("<meta name=\"viewport\" content=\"width=device-width, initial-sclae=1\">");
			out.append("<h1>Welcome to P.C. Manipulating Ghost</h1>");
			AddItems.getTable(request,response);
			
		}
			else SecurityUtils.askPassword(response);
		
		
	}





	


	
}
