package Java2.el222ja_assign1.RandomPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RandomPanel extends JPanel {
	public static Dimension size = new Dimension(300,300);
	public JPanel numberPanel = new JPanel();
	public JLabel label = new JLabel();
	int r;
	
	public RandomPanel() {
		setPreferredSize(size);
		setBackground(Color.white);
		
		numberPanel.setPreferredSize(new Dimension(size.width,2*size.height/3));
		numberPanel.setBackground(Color.white);
		label.setFont(label.getFont().deriveFont(170.0f));
		numberPanel.add(label);
		add(numberPanel);
		
		JPanel buttonPanel = createButtonPanel();
		add(buttonPanel);
	}
	
	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(size.width,size.height/3));
		buttonPanel.setBackground(Color.cyan);
		
		JButton Button = new JButton("New Random");
		buttonPanel.add(Button);
		
		Button.addActionListener(new ButtonListener());
		
		return buttonPanel;
	}
	
	private class ButtonListener implements ActionListener {
		private final Random random = new Random();
		
		public void actionPerformed(ActionEvent event) {
			int r = random.nextInt(100)+1;
			String str = "";
			str = str+r;
			System.out.println(str);
			label.setText(str);
		}
	}

}
