package Java2.el222ja_assign1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class HistogramBar extends JPanel {
	Dimension ChartSize;
	static DefaultCategoryDataset dataset;
	
	public HistogramBar() {
		Dimension size = new Dimension(720,480);
		setPreferredSize(size);
		
		dataset = new DefaultCategoryDataset();
		JFreeChart chart = ChartFactory.createBarChart(
			"Historgram",
			"Grupper",
			"Antal",
			dataset,
			PlotOrientation.VERTICAL,
			true,
			true,
			false);
	
		System.out.println(chart.getPlot().getClass().getName());
		System.out.println(chart.getPlot().getClass().getName());
	
		ChartSize = new Dimension(size);
		ChartPanel panel = new ChartPanel(chart);
		this.add(panel);
		panel.setPreferredSize(ChartSize);
	} 
	
	static void histogram(ArrayList<Integer> heltal) {
		int[] arr = new int[10]; 
			int n = 0;
			for(int i=0; i<heltal.size(); i++) {
				n=heltal.get(i); 
				if(n>=1 && n<=100) { 
					arr[(n-1)/10]++; 
				}
			}
			for(int m =0; m<arr.length; m++) {
						int start=m*10+1;
						int end = m*10+10; 
						dataset.setValue(arr[m],"Antal", (start)+ "-" +(end));
			}
	}
		
	public static void main(String[] args) {
		
		File file = new File("C:\\Temp\\heltal.txt");
		Scanner scan;
		ArrayList<Integer> heltal = new ArrayList<Integer>();
		try {
			scan = new Scanner(file);
			while(scan.hasNextInt()){
				heltal.add(scan.nextInt()); 
			}
			scan.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		JFrame frame = new JFrame( "Histogram" );
		HistogramBar chart1 = new HistogramBar();
		frame.getContentPane().add( chart1, BorderLayout.CENTER );
		frame.pack();
		frame.setVisible( true );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		chart1.histogram(heltal);
	}
}
