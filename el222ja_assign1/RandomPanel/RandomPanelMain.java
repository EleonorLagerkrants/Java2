package Java2.el222ja_assign1.RandomPanel;

import javax.swing.JFrame;

public class RandomPanelMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("RandomNumber");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100,100);
		RandomPanel panel = new RandomPanel();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

	}

}
