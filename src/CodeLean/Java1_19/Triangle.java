package CodeLean.Java1_19;

public class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return base * height * 0.5;
    }

    @Override
    public String toString() {
        return "This is Triangle";
    }
}
