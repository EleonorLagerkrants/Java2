package Java2.el222ja_assign1.ColorDisplay;

import javax.swing.JFrame;

public class ColorDisplayMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("ColorDisplay");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50,50);
		ColorDisplay panel = new ColorDisplay();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

	}

}
