import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JFrame;

// https://zetcode.com/java/jfreechart/
public class Grapher extends JFrame {
    private XYSeriesCollection dataset;
    public Grapher() {
        dataset = new XYSeriesCollection();
    }

    public void initChart() {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "position graph",
                "displacement",
                "height",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    public void addPlot() {

    }
}
