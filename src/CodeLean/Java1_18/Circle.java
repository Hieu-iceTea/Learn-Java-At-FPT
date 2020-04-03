package CodeLean.Java1_18;

public class Circle {
    // private instance variable
    private double radius;
    /** Constructs a Circle instanve with the given radius */
    public Circle(double radius) {
        this.radius = radius;
    }
    /** Returns the radius */
    public double getRadius() {
        return this.radius;
    }
    /** Returns the area of this circle */
    public double getArea() {
        return radius * radius * Math.PI;
    }
    /** Returns a self-descriptive string */
    public String toString() {
        return "Circle[radius=" + radius + "]";
    }
}
