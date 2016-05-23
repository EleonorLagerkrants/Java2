package Java2.el222ja_assign1;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OneTwoThree extends JPanel {
	static Dimension size = new Dimension(600,600);
	
	public OneTwoThree() {
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(600,200));
		panel1.setBackground(Color.blue);
		JLabel label1 = new JLabel("One");
		label1.setPreferredSize(new Dimension(600,200));
		label1.setVerticalAlignment(SwingConstants.TOP);
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(label1);
		add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(600,200));
		panel2.setBackground(Color.red);
		JLabel label2 = new JLabel("Two");
		label2.setPreferredSize(new Dimension(600,200));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(label2);
		add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(600,200));
		panel3.setBackground(Color.green);
		JLabel label3 = new JLabel("Three");
		label3.setPreferredSize(new Dimension(600,195));
		label3.setVerticalAlignment(SwingConstants.BOTTOM);
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3.add(label3);
		add(panel3);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("OneTwoThree");
		frame.setPreferredSize(new Dimension(640,660));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(30,30);
		JPanel panel = new OneTwoThree();
		panel.setPreferredSize(new Dimension(size));
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

	}

}
