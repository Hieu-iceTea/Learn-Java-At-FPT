package CodeLean;

public class Java1_10 {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5, "red");

//        circle1.setColor("red");
//        circle1.setRadius(5);

        System.out.printf("Area: %.4f", circle1.getArea());
    }
}

class Circle{
    private double radius;
    private String color;

    public Circle(){
        //None
    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public void setColor(String color){
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea(){
        return radius * radius * Math.PI;
    }
}
