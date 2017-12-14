package raj.rishi.web.ghost;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
 * Servlet required to show the screenshot of server machine from client machine
 * @author Raj
 */
@WebServlet(description = "View screen projection of server from any client", urlPatterns = { "/Screen" })
public class Screen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ScreenProject screenProject;
	private boolean auth;
	private static boolean picTaking = false;
	private Thread t;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	BufferedImage image;

    public Screen() {
    	super();
    	screenProject=new ScreenProject();
    }
    
    @Override
    public void destroy() {
    	super.destroy();
    }
    
    @Override
    public void init() {
    	if(picTaking) return;
    	t = new Thread() {
    		@Override
    		public void run() {
				picTaking = true;
    			while(true) {
    				try {
    					if(!picTaking) break;
    					long time = System.currentTimeMillis();
    			    	image = screenProject.getScreenShot();
    			    	Thread.sleep(Math.max(0, 100 - (System.currentTimeMillis() - time)));
    				}
    			    	 catch (InterruptedException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					} catch (AWTException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    			}
    		}
    	};
    	t.start();
    }
    
    /** Renders a web page on the client device with an image of jpg format containing
     * the screenshot of the server machine. Like all the other servlet methods,
	 * it requires the user to be authenticated.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SecurityUtils security=new SecurityUtils();
		auth=security.getAuthencticity(request);
		if(auth) {
			response.setContentType("image/jpg");
			ImageIO.write(image, "jpg", response.getOutputStream());
		}
		else SecurityUtils.askPassword(response);
	}


}
