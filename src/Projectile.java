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
            return Math.toDegrees(Math.atan((Math.pow(velocity, 2) - discriminant) / (gravity * distance)));
        } else {
            // higher angle of launch
            return Math.toDegrees(Math.atan((Math.pow(velocity, 2) + discriminant) / (gravity * distance)));
        }
    }

    public double[] displacementAtTime(double angle, double time) {
        angle = Math.toRadians(angle);
        double horizontalDisplacement = velocity * time * Math.cos(angle);
        double verticalDisplacement = velocity * time * Math.sin(angle) - 0.5 * gravity * Math.pow(time, 2);
        return new double[]{horizontalDisplacement, verticalDisplacement};

    }
    public double timeOfFlight(double angle) {
        return 2 * velocity * Math.sin(Math.toRadians(angle)) / gravity;
    }

}
