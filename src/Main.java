// distance given
// muzzle velocity
// CALCULATE THE FUCKING angle of LAUNCHERR!!!
public class Main {
    public static void main(String[] args) {
        Projectile projectile = new Projectile(10, 10);
        double a = projectile.angleOfProjectile(-1);
        double b = projectile.angleOfProjectile(1);
        System.out.println(projectile.distanceGivenAngle(a));
        System.out.println(projectile.distanceGivenAngle(b));
    }
}