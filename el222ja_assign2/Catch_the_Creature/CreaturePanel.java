package Java2.el222ja_assign2.Catch_the_Creature;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CreaturePanel extends JPanel implements ActionListener, MouseListener {
	private Random random = new Random();
	private Creature creature = new Creature();
	private Timer timer1;
	private int Delay;
	JLabel label = new JLabel();
	private Point p = null;
	int ClickCount;
	/*
	 * Creates the panel
	 */
	public CreaturePanel() {
		Delay = random.nextInt(2000)+100;
		timer1 = new Timer(Delay,this);
		setBackground(Color.white);
		setPreferredSize(new Dimension(400,400));
		add(label);
		timer1.start();
		this.addMouseListener(this); 
	}
	/*
	 * What happens when the creature is clicked
	 */
	public void actionPerformed(ActionEvent event) {
		int x = random.nextInt(getWidth()-creature.getWidth());
		int y = random.nextInt(getHeight()-creature.getHeight());
		creature.move(x,y);
		repaint();
		ClickCount=creature.getClickCount();
	}
	/*
	 * what happens when the mouse is clicked
	 */
	public void mouseClicked(MouseEvent event) {	
		Point p = event.getPoint();
		creature.Clicked(p);
		int x = random.nextInt(getWidth()-creature.getWidth());
		int y = random.nextInt(getHeight()-creature.getHeight());
		creature.move(x,y);
		ClickCount=creature.getClickCount();
	}
	public void mouseMoved(MouseEvent event) {}
	public void mousePressed (MouseEvent event) {}
    public void mouseExited (MouseEvent event) {}
    public void mouseDragged (MouseEvent event) {}
    public void mouseReleased (MouseEvent event) {}
    public void mouseEntered (MouseEvent event) {}
	
    /*
     * Paints the label on the panel
     */
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	creature.paint(g);
    	label.setText("Antal träffar: "+ClickCount);
	}
    
    public static void main(String[] args) {
		JFrame frame = new JFrame("Catch The Creature");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50,50);
		
		CreaturePanel panel = new CreaturePanel();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
    }
}
    
