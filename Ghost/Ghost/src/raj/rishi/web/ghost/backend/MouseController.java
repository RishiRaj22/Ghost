package raj.rishi.web.ghost.backend;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MouseController {
	private static Robot robot;
	static {
		if(robot == null)
			try {
				robot = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void moveMouse(double x,double y) {
		double mx = MouseInfo.getPointerInfo().getLocation().getX();
		mx += x/6;
		double my = MouseInfo.getPointerInfo().getLocation().getY();
		my += y/6;
		robot.mouseMove((int)mx,(int)my);
	}
	public static void mouseClick(String type) {
		if(type.equals("l")) {
	        robot.mousePress(InputEvent.BUTTON1_MASK);
	        // release the left mouse button
	        robot.mouseRelease(InputEvent.BUTTON1_MASK);
		}
		else if(type.equals("r")) {
	        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
	        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		}
	}

}
