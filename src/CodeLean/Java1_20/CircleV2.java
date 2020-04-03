package CodeLean.Java1_20;

public class CircleV2 implements GeometricObject {
    protected double radius;

    public CircleV2(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "CircleV2{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public double getArea() {
        return 0;
    }
}
