
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GUI implements KeyListener {

	boolean freeze = false;
	
	private JFrame mainFrame;
	private JFrame colorFrame;
	
	private JPanel colorPanel;
	private JPanel mainPanel;
	
	JTextPane labelRGB;
	JTextPane labelHex;
	JTextPane infoLabel;
	
	
	public GUI() {
		
		//MAÝN FRAME WÝTH LABELS
		mainFrame = new JFrame("ValPix");
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setAlwaysOnTop(true);
		
		mainPanel = new JPanel();
		
		infoLabel = new JTextPane();
		labelRGB = new JTextPane();
		labelHex = new JTextPane();
		
		infoLabel.setContentType("text/html"); 
		infoLabel.setText("<html>First click here to focus program then press space to freeze value</html>");
		infoLabel.setEditable(false); 
		infoLabel.setBackground(null); 
		infoLabel.setBorder(null); 
		
		labelRGB.setContentType("text/html"); 
		labelRGB.setEditable(false); 
		labelRGB.setBackground(null); 
		labelRGB.setBorder(null); 
		
		labelHex.setContentType("text/html"); 
		labelHex.setEditable(false); 
		labelHex.setBackground(null); 
		labelHex.setBorder(null); 
		
		mainPanel.setBorder(new EmptyBorder(new Insets(10, 20, 25, 20)));
		mainPanel.add(infoLabel);
		mainPanel.add(labelRGB);
		mainPanel.add(labelHex);
		mainFrame.add(mainPanel);
		
		mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(),BoxLayout.Y_AXIS));
		
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		//COLOR FRAME
		colorFrame = new JFrame("Color");
		colorFrame.setSize(40, 40);
		colorFrame.setUndecorated(true);
		colorFrame.setAlwaysOnTop(true);
		
		colorPanel = new JPanel();
		colorPanel.setPreferredSize(new Dimension(120, 120));
		colorPanel.setBorder(LineBorder.createGrayLineBorder());
		
		colorFrame.add(colorPanel);
		
		colorFrame.setVisible(true);
		
		infoLabel.addKeyListener(this);
		labelHex.addKeyListener(this);
		labelRGB.addKeyListener(this);

	}
	
	public void setFrameColor(Color color) {
		colorPanel.setBackground(color);
	}
	
	public void setRGBLabel(Color color) {
		labelRGB.setText("<html>RGB value: "+color.getRed()+" "+color.getGreen()+" "+color.getBlue()+"</html>");
	}
	
	public void setHexLabel(Color color) {
		String hex = "Hex value: #"+Integer.toHexString(color.getRGB()).substring(2);
		labelHex.setText("<html>"+hex+"</html>");
	}
	
	public void followMouse(int x,int y) {
		colorFrame.setLocation(x+5, y+5);	
	}
	
	
	//KeyListener
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
		if(e.getKeyCode() == KeyEvent.VK_SPACE && !freeze) {			
			freeze = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
