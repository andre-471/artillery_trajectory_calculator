import java.text.DecimalFormat;

// distance given
// muzzle velocity
public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat(".##");
        Projectile projectile = new Projectile(21000, 827);

        double lower = projectile.angleOfProjectile(-1);
        double higher = projectile.angleOfProjectile(1);

        if (!Double.isNaN(lower) || !Double.isNaN(higher)) {
            System.out.println("Angle needed to reach target:");
            System.out.println(df.format(lower) + "° OR " + df.format(higher) + "°");
            System.out.println("Time to reach target:");
            System.out.println(df.format(projectile.timeOfFlight(lower)) + "s OR "
                    + df.format(projectile.timeOfFlight(higher)) + "s");

            Grapher grapher = new Grapher();
            grapher.addProjectile(projectile);
            grapher.display();
        } else {
            System.out.println("Impossible to reach target.");
        }
    }
}
