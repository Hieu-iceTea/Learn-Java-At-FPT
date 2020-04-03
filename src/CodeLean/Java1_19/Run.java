/**
 * [Java1_19] Abstract Classes & Interfaces
 * https://www.codelean.vn/2020/03/jp10-abstract-classes-interfaces.html
 */
package CodeLean.Java1_19;

public class Run {
    public static void main(String[] args) {
        testShape();
    }

    private static void testShape() {
        Shape shape = new Shape("c") {
            @Override
            public double getArea() {
                return 5000;
            }
        };

        System.out.println(shape);
        System.out.println("Area is: " + shape.getArea());

        Rectangle rectangle = new Rectangle(2, 5);
        System.out.println(rectangle);
        System.out.println("Area is: " + rectangle.getArea());
    }
}
