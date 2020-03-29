package CodeLean.Java1_16;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(){
        super(); //Có hay không đều được, vì đây là mặc định
    }

    public Cylinder(double height) {
        super(); //Có hay không đều được, vì đây là mặc định
        this.height = height;
    }

    public Cylinder(double height, double radius) {
        super(radius); //Phải có
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color); //Phải có
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        return "This is a Cylinder";
    }

    public double getVolume() {
        return super.getArea() * height;
    }
}
