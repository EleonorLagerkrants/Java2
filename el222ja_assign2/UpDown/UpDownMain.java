package Java2.el222ja_assign2.UpDown;

import javax.swing.JFrame;

public class UpDownMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("UpDown");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50,50);
		
		UpDown panel = new UpDown();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(panel);

	}

}
