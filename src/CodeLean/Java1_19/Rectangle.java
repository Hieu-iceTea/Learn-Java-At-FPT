package CodeLean.Java1_19;

public class Rectangle extends Shape implements IShape {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return String.format("Rectangle[length=, width=]", length, width);
    }



    @Override
    public double getPerimeter() {
        return (length + width) * 2;
    }
}
