package raj.rishi.web.ghost;

import java.awt.AWTException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;

import raj.rishi.web.ghost.backend.ScreenProject;
import raj.rishi.web.ghost.utils.SecurityUtils;

/**
 * Servlet implementation class Screen
 */
@WebServlet(description = "View screen projection.... pretty moonshot", urlPatterns = { "/Screen" })
public class Screen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScreenProject screenProject;
	private boolean auth;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Screen() {
    	super();
    	screenProject=new ScreenProject();
    }
    @Override
    public void destroy() {
    	super.destroy();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SecurityUtils security=new SecurityUtils();
		auth=security.getAuthencticity(request, response);
		if(auth)
		{
		response.setContentType("image/jpg");
		try {
			JPEGCodec.createJPEGEncoder(response.getOutputStream()).encode(screenProject.getScreenShot());
			Thread.sleep(100);
		} catch (ImageFormatException e) { 
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("<img src=\"screen.jpg\">");
		}
		else SecurityUtils.askPassword(response);
	}
	
	


}
