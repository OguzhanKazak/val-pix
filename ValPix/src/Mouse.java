import java.awt.MouseInfo;
import java.awt.PointerInfo;

public class Mouse {
	
	private double mouseX;
	private double mouseY;
	
	public int getMouseX() {
		return (int) mouseX;
	}


	public int getMouseY() {
		return (int) mouseY;
	}



	public void getMousePosition() {
		PointerInfo mouseInfo = MouseInfo.getPointerInfo();
		mouseX =  mouseInfo.getLocation().getX();
		mouseY =  mouseInfo.getLocation().getY();
	}
	
	
	public String toString() {
		return "x: "+mouseX+" y:"+mouseY;
	}
	
	
}
