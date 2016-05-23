package Java2.el222ja_assign1;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.lang.Math;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

public class SinMain extends JPanel {
	public static XYSeries series;
	
	public SinMain() {
		series = new XYSeries(" y = (1 + x/pi)*cos(x)*cos(40*x)");
		getY(0);
		XYSeriesCollection dataset = new XYSeriesCollection(series);
		JFreeChart chart = ChartFactory.createXYLineChart(
				"SinMain",
				"X",
				"Y",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false
				);
		
		System.out.println(chart.getPlot().getClass().getName());
		System.out.println(chart.getXYPlot().getRenderer().getClass().getName());
		
		
		ChartPanel panel = new ChartPanel( chart );
		this.add( panel );
	}
	
	
	public static double x;
	public static double y;
	
	public static double getY(double x) {
		for(x=0; x<(2*Math.PI); x+=0.01 ) {
			y=(1+(x)/(Math.PI))*Math.cos((x))*Math.cos(40*(x));
			series.add(x,y);
		}
	return y;
	}
	

	public static void main(String[] args) {
		JFrame frame = new JFrame( "SinMain" );
		SinMain chart = new SinMain();
		frame.getContentPane().add( chart, BorderLayout.CENTER );
		frame.setSize( 740, 480 );
		frame.pack();
		frame.setVisible( true );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}
