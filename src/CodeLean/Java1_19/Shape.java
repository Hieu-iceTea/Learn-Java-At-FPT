package CodeLean.Java1_19;

public abstract class Shape {
    private String color;

    public Shape() {
        //nothing
    }

    public Shape(String color) {
        this.color = color;
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return "This is Shape";
    }
}
