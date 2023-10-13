public class Projectile {
    private static final double gravity = 9.807;
    private double distance;
    private double velocity;

    public Projectile(double distance, double velocity) {
        this.distance = distance;
        this.velocity = velocity;
    }

    public void setDistance(double newDistance) {
        distance = newDistance;
    }

    // https://en.wikipedia.org/wiki/Projectile_motion#Angle_%CE%B8_required_to_hit_coordinate_(x,_y)
    public double angleOfProjectile(int sign) {
        double discriminant = Math.pow(Math.pow(velocity, 4) - gravity * (gravity * Math.pow(distance, 2)), 0.5);
        if (sign < 0) {
            // lower angle of launch
            return Math.toRadians(Math.atan((Math.pow(velocity, 2) - discriminant) / (gravity * distance)));
        } else {
            // higher angle of launch
            return Math.toRadians(Math.atan((Math.pow(velocity, 2) + discriminant) / (gravity * distance)));
        }
    }

    public double distanceGivenAngle(double angle) {
        return Math.pow(velocity, 2) * Math.sin(2 * Math.toDegrees(angle)) / Math.abs(gravity);
    }


}
