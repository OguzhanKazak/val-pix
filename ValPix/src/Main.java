import java.awt.AWTException;
import java.awt.Color;

public class Main {
	
	
	public static void main(String[] args) throws AWTException {
		
		
		Mouse mouse = new Mouse();
		PixelReader screenCapt = new PixelReader();
		Color pixelColor = null;
		
		GUI screen = new GUI();
		
		
		while(!screen.freeze) {
			mouse.getMousePosition();
			pixelColor = screenCapt.getPixel(mouse.getMouseX(),mouse.getMouseY());
			screen.followMouse(mouse.getMouseX(),mouse.getMouseY());
			
			screen.setFrameColor(pixelColor);
			screen.setHexLabel(pixelColor);
			screen.setRGBLabel(pixelColor);
		}
	}
	
}
