package CodeLean.Java1_18;

public class Cylinder extends Circle{
    // private instance variable
    private double height;
    /** Constructs a Cylinder instance with the given height and radius */
    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }
    /** Returns the height */
    public double getHeight() {
        return this.height;
    }
    /** Returns the volume of this cylinder */
    public double getVolumne() {
        return super.getArea() * height;
    }
    /** Overrides the inherited method to return the surface area */
    @Override
    public double getArea() {
        return 2.0 * Math.PI * getRadius() * height;
    }
    /** Override the inherited method to describe itself */
    @Override
    public String toString() {
        return "Cylinder[height=" + height + "," + super.toString() + "]";
    }
}
