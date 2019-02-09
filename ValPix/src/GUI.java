
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class GUI implements KeyListener {

	boolean freeze = false;
	
	private JFrame mainFrame;
	private JFrame colorFrame;
	
	private JPanel colorPanel;
	private JPanel mainPanel;
	
	JLabel labelRGB;
	JLabel labelHex;
	JLabel infoLabel;
	
	Button copyToClipBoardButton;
	
	
	public GUI() {
		
		//MA�N FRAME W�TH LABELS
		mainFrame = new JFrame("ValPix");
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setAlwaysOnTop(true);
		
		mainPanel = new JPanel();
		
		infoLabel = new JLabel("First click here to focus program then press space to freeze value");
		labelRGB = new JLabel();
		labelHex = new JLabel();
		
		copyToClipBoardButton = new Button("Copy Values");
		copyToClipBoardButton.enable(false);
		copyToClipBoardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StringSelection stringSelection = new StringSelection(labelRGB.getText()+" "+labelHex.getText());
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
		});
		
		mainPanel.setBorder(new EmptyBorder(new Insets(10, 20, 25, 20)));
		mainPanel.add(infoLabel);
		mainPanel.add(labelRGB);
		mainPanel.add(labelHex);
		mainPanel.add(copyToClipBoardButton);
		
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
		
		mainFrame.addKeyListener(this);

	}
	
	public void setFrameColor(Color color) {
		colorPanel.setBackground(color);
	}
	
	public void setRGBLabel(Color color) {
		labelRGB.setText("RGB value: "+color.getRed()+" "+color.getGreen()+" "+color.getBlue());
	}
	
	public void setHexLabel(Color color) {
		String hex = "Hex value: #"+Integer.toHexString(color.getRGB()).substring(2);
		labelHex.setText(hex);
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
			copyToClipBoardButton.enable(true);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
