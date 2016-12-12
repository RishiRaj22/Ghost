package raj.rishi.web.ghost.backend;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

/**
 * This class is used to get screenshot
 * @author Raj
 *
 */
public class ScreenProject {
	int x,y;
	public ScreenProject()
	{
		x=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		y=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	}
	/**
	 * This method is used to get the screen shot as a buffered image to be displayed.
	 * @return
	 * @throws AWTException
	 */
	public BufferedImage getScreenShot () throws AWTException
	{
		Robot robot=new Robot();
		return robot.createScreenCapture(new Rectangle(0,0,x,y));
	}

}
