package CodeLean.Java1_16;

public class Circle {
    private double radius;
    private String color;

    public Circle(){
        //nothing
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return String.format("Circle[color=%s, radius=%.4f]", color, radius);
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}
