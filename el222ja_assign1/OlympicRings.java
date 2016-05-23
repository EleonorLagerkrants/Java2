package Java2.el222ja_assign1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class OlympicRings extends JPanel {
	Color OlympicBlue = new Color(0,122,201);
	Color OlympicRed = new Color(255,14,73);
	Color OlympicBlack = new Color(0,0,0);
	Color OlympicYellow = new Color(255,161,0);
	Color OlympicGreen = new Color(0,155,58);
	
	public static void main(String[] args) {	
	
		final int X = 100;   
		final int Y = 100;   
		final int WIDTH = 500;
		final int HEIGHT = 400;
		final String TITLE = "Olympic Rings";
		final Color BACKGROUND = Color.white;
		
		JPanel panel = new OlympicRings();
		
		
		JFrame frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(X,Y);
		panel.setBackground(BACKGROUND);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void drawRing(Graphics g2) {
		g2.setColor(OlympicBlue);
		g2.drawOval(20, 50, 150, 150);
		g2.setColor(OlympicYellow);
		g2.drawOval(100, 120, 150, 150);
		g2.setColor(OlympicBlack);
		g2.drawOval(180, 50, 150, 150);
		g2.setColor(OlympicGreen);
		g2.drawOval(260, 120, 150, 150);
		g2.setColor(OlympicRed);
		g2.drawOval(340, 50, 150, 150);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(8));
		drawRing(g2);
		g2.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Sweden will take plenty of medalls in Sotji!",50 ,350);
	}

}
