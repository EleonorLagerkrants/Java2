package Java2.el222ja_assign1.ColorDisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ColorDisplay extends JPanel {
	public static Dimension size = new Dimension(620,620);
	public JPanel colorPanel = new JPanel();
	private JTextField redField;
	private JTextField greenField;
	private JTextField blueField;
	public int r;
	public int g;
	public int b;
	
	public ColorDisplay() {
		setPreferredSize(size);
		setBackground(Color.white);
		
		colorPanel.setPreferredSize(new Dimension(620,350));
		colorPanel.setBackground(Color.white);
		add(colorPanel);
		
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(620,200));
		add(textPanel);
		
		JPanel redPanel = new JPanel();
		redPanel.setPreferredSize(new Dimension(200,200));
		redPanel.setBackground(Color.red);
		textPanel.add(redPanel);
		JLabel red = new JLabel("Red");
		red.setPreferredSize(new Dimension(200,100));
		red.setHorizontalAlignment(SwingConstants.CENTER);
		red.setFont(red.getFont().deriveFont(30.0f));
		redPanel.add(red);
		redField = new JTextField(3);
		redField.setFont(new Font("Ariel",Font.BOLD,24));
		redPanel.add(redField);
		
		JPanel greenPanel = new JPanel();
		greenPanel.setPreferredSize(new Dimension(200,200));
		greenPanel.setBackground(Color.green);
		textPanel.add(greenPanel);
		JLabel green = new JLabel("Green");
		green.setPreferredSize(new Dimension(200,100));
		green.setHorizontalAlignment(SwingConstants.CENTER);
		green.setFont(green.getFont().deriveFont(30.0f));
		greenPanel.add(green);
		greenField = new JTextField(3);
		greenField.setFont(new Font("Ariel",Font.BOLD,24));
		greenPanel.add(greenField);
		
		JPanel bluePanel = new JPanel();
		bluePanel.setPreferredSize(new Dimension(200,200));
		bluePanel.setBackground(Color.blue);
		textPanel.add(bluePanel);
		JLabel blue = new JLabel("Blue");
		blue.setPreferredSize(new Dimension(200,100));
		blue.setHorizontalAlignment(SwingConstants.CENTER);
		blue.setFont(blue.getFont().deriveFont(30.0f));
		bluePanel.add(blue);
		blueField = new JTextField(3);
		blueField.setFont(new Font("Ariel",Font.BOLD,24));
		bluePanel.add(blueField);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(620,150));
		buttonPanel.setBackground(Color.gray);
		add(buttonPanel);
		JButton button = new JButton("Display Color");
		button.setPreferredSize(new Dimension(150,50));
		buttonPanel.add(button);
		
		button.addActionListener(new ButtonListener());
	}
	
	public class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			String red = redField.getText();
			String green = greenField.getText();
			String blue = blueField.getText();
			
			try {
			int r = Integer.parseInt(red);
			int g = Integer.parseInt(green);
			int b = Integer.parseInt(blue);
			if(r>=0 && r<=255 && g>=0 && g<=255 && b>=0 && b<=255) {
				Color color = new Color(r,g,b);
				colorPanel.setBackground(color);
			}
			else {
				System.err.println("Ange ett heltal mellan 0 och 255."); 
			}
			}
			catch (NumberFormatException e) {
				System.err.println("Ange ett heltal mellan 0 och 255.");
			}
				
		}
	}
}
