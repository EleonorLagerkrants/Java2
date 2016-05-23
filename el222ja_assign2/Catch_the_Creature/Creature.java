package Java2.el222ja_assign2.Catch_the_Creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Creature {
	private int clicked=0;
	private ImageIcon image;
	private int x,y;
	public boolean visible = true;
	
	/*
	 * Creates the creature
	 */
	public Creature() {
		image = new ImageIcon("C:\\Users\\Eleonor\\workspace\\Programvaruteknik\\src\\Java2\\el222ja_assign2\\Catch_the_Creature\\happyface.gif");
	}
	/*
	 * Determines if the area that was clicked is the same as the image is in
	 */
	public boolean Clicked(Point p) {
		if(p.x>=x&&p.x<=(x+image.getIconWidth())&&p.y>=y&&p.y<=(y+image.getIconHeight())) {
		clicked ++;
		return true;
	}
		else {
			return false;
		}
	}
	/*
	 * returns the width of the image
	 */
	public int getWidth() {
		return image.getIconWidth();
	}
	/*
	 * returns the height of the image
	 */
	public int getHeight() {
		return image.getIconHeight();
	}
	/*
	 * returns how many times the image have been clicked
	 */
	public int getClickCount() {
		return clicked;
	}
	/*
	 * moves the creature
	 */
	public void move(int xMove, int yMove) {
		x=xMove;
		y=yMove;
	}
	/*
	 * paints the creature
	 */
	public void paint(Graphics g) {
		g.drawImage(image.getImage(), x, y, Color.white, null);
	}
	}
