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

// distance given
// muzzle velocity
// CALCULATE THE FUCKING angle of LAUNCHERR!!!
public class Main {
    public static void main(String[] args) {
        Projectile projectile = new Projectile(100, 39);
        double a = projectile.angleOfProjectile(-1);
        double b = projectile.angleOfProjectile(1);


        XYSeries seriesa = new XYSeries("lower");
        for (double i = 0; i <= projectile.timeOfFlight(a); i += projectile.timeOfFlight(a)/100) {
            double[] coords = projectile.displacementAtTime(a, i);
            seriesa.add(coords[0], coords[1]);
        }
        XYSeries seriesb = new XYSeries("higher");
        for (double i = 0; i <= projectile.timeOfFlight(b); i += projectile.timeOfFlight(a)/100) {
            double[] coords = projectile.displacementAtTime(b, i);
            seriesb.add(coords[0], coords[1]);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesa);
        dataset.addSeries(seriesb);

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
        XYPlot plot = chart.getXYPlot();

        XYSplineRenderer renderer = new XYSplineRenderer(1);
        plot.setRenderer(renderer);

        ChartPanel chartPanel = new ChartPanel(chart);

        JFrame frame = new JFrame("Line Chart");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
