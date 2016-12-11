package raj.rishi.web.ghost.backend;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class ScreenProject {
	int x,y;
	public ScreenProject()
	{
		x=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		y=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	}
	public BufferedImage getScreenShot () throws AWTException
	{
		Robot robot=new Robot();
		return robot.createScreenCapture(new Rectangle(0,0,x,y));
	}

}
