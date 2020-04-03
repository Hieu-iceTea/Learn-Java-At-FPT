/**
 * [Java1_17]  Luyện Tập về Thừa Kế Trong Java
 * https://www.codelean.vn/2020/03/java117-luyen-tap-ve-thua-ke-trong-java.html
 */

package CodeLean.Java1_17;

public class Run {
    public static void main(String[] args) {
        //testPerson();
        //testPoint();
        //testMovablePoint();
        //testShape();
    }

    private static void testPerson() {
        Person person1 = new Person("Hiếu iceTea", "Hà Nội");
        System.out.println(person1);

        Student student1 = new Student("Nguyễn Đình Hiếu", "Nghệ An", "Java", 2020, 15);
        System.out.println(student1);

        Staff staff1 = new Staff("Phan Thị", "Hà Nội", "FPT", 20);
        System.out.println(staff1);
    }

    private static void testPoint() {
        //TODO Sẽ hỏi cô chỗ này: vì sao truyền vào 2.5 không được?
        Point2D point2D_1 = new Point2D(2, 3);
        System.out.println(point2D_1);

        Point3D point3D_1 = new Point3D(5, 8, 9);
        System.out.println(point3D_1);
    }

    private static void testMovablePoint() {
        MovablePoint movablePoint1 = new MovablePoint();
        MovablePoint movablePoint2 = new MovablePoint(2, 3);
        MovablePoint movablePoint3 = new MovablePoint(5, 6, 8, 9);

        System.out.println(movablePoint1);
        System.out.println(movablePoint2);
        System.out.println(movablePoint3);

        movablePoint1.setXY(5, 10);
        movablePoint1.setSpeed(15, 20);
        System.out.println(movablePoint1);

        System.out.println(movablePoint1.move());

        movablePoint1.move();
        System.out.println(movablePoint1);
    }

    private static void testShape() {
        //Shape
        System.out.println("They are Shape:");
        Shape shape1 = new Shape();
        Shape shape2 = new Shape("blue", true);
        System.out.println(shape1);
        System.out.println(shape2);
        System.out.println(shape2.isFilled());

        shape1.setColor("black");
        shape1.setFilled(false);
        System.out.println(shape1);

        //Circle
        System.out.println("They are Circle:");
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(15);
        Circle circle3 = new Circle(20, "yellow", false);

        System.out.println(circle1);
        System.out.println(circle2);
        System.out.println(circle3);

        //Rectangle
        System.out.println("They are Rectangle:");
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(3, 6);
        Rectangle rectangle3 = new Rectangle(8, 9, "Blue", false);

        System.out.println(rectangle1);
        System.out.println(rectangle2);
        System.out.println(rectangle3);

        //Square
        System.out.println("They are Square:");
        Square square1 = new Square();
        Square square2 = new Square(20);
        Square square3 = new Square(55, "Green", false);

        System.out.println(square1);
        System.out.println(square2);
        System.out.println(square3);

        square1.setSide(50);
        System.out.println(square1);

        square1.setWidth(60);
        System.out.println(square1);

        square1.setLength(80);
        System.out.println(square1);
    }
}
