package Java2.el222ja_assign2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BounceBall extends JFrame {
	public ShapePanel drawPanel;
	   public Vector<NewBall> Balls;
	   public JTextField message;
	   public JButton button = new JButton("New Ball");
	   public JPanel ButtonPanel;

	   /*
	    * Creates a new window 
	    */
	   public BounceBall()  {
		   
	      super("BouncingBall");
	      drawPanel = new ShapePanel(500, 500);
	      message = new JTextField();
	      message.setEditable(false);
	      
	      ButtonPanel = new JPanel();
	      ButtonPanel.setPreferredSize(new Dimension(100,100));
	      add(button);
		  button.addActionListener(new ButtonListener());
	     
	      Balls = new Vector<NewBall>();
	      add(drawPanel, BorderLayout.NORTH);
	      add(message, BorderLayout.SOUTH);
	  
	      setSize(600, 600);
	      setVisible(true);
	   } 

	   public static void main(String args[])  {
		   
		   BounceBall application = new BounceBall();
		      application.addWindowListener(
		         new WindowAdapter()
		         {
		            public void windowClosing(WindowEvent e)  
		            {
		               System.exit(0);
		            }
		         }
		      );
		   }
	     /* 
	      * Creates ball with random size and speed
	      */
	   public class NewBall extends Thread
	   {
	      private Ellipse2D.Double thisBall;
	      private boolean ballStarted;
	      private int size, speed;          
	      private int deltax, deltay;        
	  
	      public NewBall()
	      {
	       
	         ballStarted = true;   
	         size = 10 + (int)(Math.random() * 60);
	         speed = 10 + (int)(Math.random() * 100);
	         int startx = 250;
	         int starty = 250;
	         deltax = -10 + (int)(Math.random() * 21);
	         deltay = -10 + (int)(Math.random() * 21);
	         if ((deltax == 0) && (deltay == 0)) { deltax = 1; }
	         thisBall = new Ellipse2D.Double(startx, starty, size, size);
	      }

	      
	      public void draw(Graphics2D g2d)
	      {
	         if (thisBall != null)
	         {
	            g2d.setColor(Color.BLUE);
	            g2d.fill(thisBall);
	         }
	      }

	      public void run()
	      {
	         while(ballStarted)  
	         {
	           try {
	               Thread.sleep(speed);
	            }
	            catch (InterruptedException e)
	            {  System.out.println("Woke up prematurely");}

	            /*
	             * Calculate new position and move ball
	             */
	            int oldx = (int) thisBall.getX();
	            int oldy = (int) thisBall.getY();
	            int newx = oldx + deltax;
	            if (newx + size > drawPanel.getWidth() || newx < 0) 
	               deltax = -deltax;
	            int newy = oldy + deltay;
	            if (newy + size > drawPanel.getHeight() || newy < 0) 
	               deltay = -deltay;            
	            thisBall.setFrame(newx, newy, size, size);
	           
	            drawPanel.repaint();
	         }
	      }
	   }

	   /*
	    * The panel where the ball will be drawed
	    */
	   public class ShapePanel extends JPanel {
	      private int prefwid, prefht;
	         
	      public ShapePanel (int pwid, int pht)
	      {
	         prefwid = pwid;
	         prefht = pht;
		    
	      }
	     
	     
	      public Dimension getPreferredSize()
	      {
	         return new Dimension(prefwid, prefht);
	      }

	      public void paintComponent (Graphics g)  
	      {
	          super.paintComponent(g);
	          Graphics2D g2d = (Graphics2D) g;
	          for (int i = 0; i < Balls.size(); i++) 
	          { 
	             (Balls.elementAt(i)).draw(g2d);
	          }
	      }
		}		  	  
	   
	/*
	 * what happens when you press the button
	 */
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			NewBall nextBall = new NewBall();
            Balls.addElement(nextBall);
            nextBall.start();
            message.setText("Number of Balls: " + Balls.size());
	}
}
}