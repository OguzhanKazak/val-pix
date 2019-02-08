import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;

public class PixelReader  {
	Robot robot;
	
	public PixelReader()throws AWTException{
		robot = new Robot();
	}
	
	public Color getPixel(int x,int y) {
		return robot.getPixelColor(x, y);
	}


}
