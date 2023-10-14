import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JFrame;

// https://zetcode.com/java/jfreechart/
public class Grapher extends JFrame {  // something about inheritance
    private XYSeriesCollection dataset;
    private JFreeChart chart;
    public Grapher() {
        dataset = new XYSeriesCollection();
        chart = ChartFactory.createXYLineChart(
                "position graph",
                "displacement (m)",
                "height (m)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    public void addProjectile(Projectile projectile) {
        double lowerAngle = projectile.angleOfProjectile(-1);
//        double higherAngle = projectile.angleOfProjectile(1);

        if (!Double.isNaN(lowerAngle)) {
            dataset.addSeries(iteratePoints(projectile, lowerAngle, "Lower Angle"));
        }

//        inaccurate do not use
//        if (!Double.isNaN(higherAngle)) {
//            dataset.addSeries(iteratePoints(projectile, higherAngle, "Higher Angle"));
//        }
    }

    private XYSeries iteratePoints(Projectile projectile, double angle, String axis) {
        XYSeries series = new XYSeries(axis);
        double flightTime = projectile.timeOfFlight(angle);
        for (double i = 0; i <= flightTime; i += flightTime/50) {
            double[] coords = projectile.displacementAtTime(angle, i);
            series.add(coords[0], coords[1]);
        }
        double[] coords = projectile.displacementAtTime(angle, flightTime);
        series.add(coords[0], coords[1]);
        return series;
    }

    public void display() {
        chart.getXYPlot().setRenderer(new XYSplineRenderer());
        add(new ChartPanel(chart));
        pack();
        setTitle("Line Chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
