package Java2.el222ja_assign2.UpDown;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UpDown extends JPanel implements KeyListener {
	private final Dimension panelSize = new Dimension(600,600);
	private final Color background = Color.white;
	private ImageIcon icon = new ImageIcon("C:\\Users\\Eleonor\\workspace\\Programvaruteknik\\src\\Java2\\el222ja_assign2\\UpDown\\red_devil.gif");
	private JLabel iconLabel = new JLabel(icon);
	private int m; int n;
	private JPanel panelHolder[][]; 
	private JPanel start;
	
	/*
	 * Creates panel with gridlayout
	 */
	public UpDown() {
		setPreferredSize(panelSize);
		setBackground(background);
		int i=7;
		int j=7;

		setLayout(new GridLayout(i,j));
		panelHolder=new JPanel[i][j];
		for(int m=0; m<i; m++) {
			for(int n=0; n<j; n++) {
				panelHolder[m][n]=new JPanel();
				panelHolder[m][n].setBorder(BorderFactory.createLineBorder(Color.black));
				add(panelHolder[m][n]);
			}
		}
		/*
		 * Set tha label in the middle of the grid
		 */
		m=3;
		n=3;
		start = panelHolder[3][3];
		start.add(iconLabel);
	
	}
	
	/*
	 * What happens when pressing different keys
	 * when pressing up,down,left,right the creature will move. When pressing other keys a error message is displayed
	 */
	public void keyPressed(KeyEvent event) {
		int keyCode = event.getKeyCode();
				
		if (keyCode == KeyEvent.VK_UP) {
			if(m==0) {
				m=6;
				start = panelHolder[m][n];
				start.add(iconLabel);
				revalidate();
				repaint();
			}
			else {
				m=m-1;
				start = panelHolder[m][n];
				start.add(iconLabel);
				revalidate();
				repaint();
			}
			}
		else if (keyCode == KeyEvent.VK_DOWN) {
			if(m==6) {
				m=0;
				start = panelHolder[m][n];
				start.add(iconLabel);
				revalidate();
				repaint();
			}
			else {
				m=m+1;
				start = panelHolder[m][n];
				start.add(iconLabel);
				revalidate();
				repaint();
			}
		}	
			else if (keyCode == KeyEvent.VK_LEFT) {
				if(n==0) {
					n=6;
					start = panelHolder[m][n];
					start.add(iconLabel);
					revalidate();
					repaint();
				}
				else {
					n=n-1;
					start = panelHolder[m][n];
					start.add(iconLabel);
					revalidate();
					repaint();
				}
			}
			else if (keyCode == KeyEvent.VK_RIGHT) {
				if(n==6) {
					n=0;
					start = panelHolder[m][n];
					start.add(iconLabel);
					revalidate();
					repaint();
				}
				else {
					n=n+1;
					start = panelHolder[m][n];
					start.add(iconLabel);
					revalidate();
					repaint();
				}
			}
			else {
				System.out.println("Unknown key pressed: "+keyCode);
				}
			}
	public void keyTyped(KeyEvent event) {}
	public void keyReleased(KeyEvent event) {}

	}
