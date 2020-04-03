package CodeLean.Java1_20;

public class Run {
    public static void main(String[] args) {
        //testShape();
        //testAnimal();
        //testMovable();
        testCircleV2();
    }

    public static void testShape() {
        Shape shape1 = new Circle(5.5, "green", true);
        System.out.println(shape1);

        Circle circle1 = (Circle) shape1;
        System.out.println(circle1);

        Shape shape2 = new Shape() {
            @Override
            public double getArea() {
                return 0;
            }

            @Override
            public double getPerimeter() {
                return 0;
            }
        };

        Shape shape3 = new Rectangle(1, 2, "red", false);
        System.out.println(shape3);

        Rectangle rectangle1 = (Rectangle) shape3;
        System.out.println(rectangle1);


        Shape shape4 = new Square(6.6);
        System.out.println(shape4);

        Rectangle rectangle2 = (Rectangle) shape4;
        System.out.println(rectangle2);

        Square square1 = (Square) rectangle2;
        System.out.println(square1);
    }

    public static void testAnimal() {
        // Using the subclasses
        Cat cat1 = new Cat();
        cat1.greeting();
        Dog dog1 = new Dog();
        dog1.greeting();
        BigDog bigDog1 = new BigDog();
        bigDog1.greeting();

        // Using Polymorphism
        Animal animal1 = new Cat();
        animal1.greeting();
        Animal animal2 = new Dog();
        animal2.greeting();
        Animal animal3 = new BigDog();
        animal3.greeting();
        /**Animal animal4 = new Animal();*/ //Lỗi

        // Downcast
        Dog dog2 = (Dog)animal2;
        BigDog bigDog2 = (BigDog)animal3;
        Dog dog3 = (Dog)animal3;
        //Cat cat2 = (Cat)animal2; //Lỗi
        dog2.greeting(dog3);
        dog3.greeting(dog2);
        dog2.greeting(bigDog2);
        bigDog2.greeting(dog2);
        bigDog2.greeting(bigDog1);
    }

    public static void testMovable() {
        Movable movable1 = new MovablePoint(5, 6, 1, 2);
        System.out.println(movable1);
        movable1.moveLeft();
        movable1.moveUp();
        System.out.println(movable1);

        Movable movable2 = new MovableCircle(20, 60, 5, 8, 25);
        System.out.println(movable2);
        movable2.moveRight();
        movable2.moveDown();
        System.out.println(movable2);
    }

    public static void testCircleV2() {
        CircleV2 circleV2_1 = new CircleV2(2);
        System.out.println(circleV2_1);

        ResizableCircleV2 resizableCircleV2_1 = new ResizableCircleV2(5);
        System.out.println(resizableCircleV2_1);
        System.out.println("Radius = " + resizableCircleV2_1.radius);
    }
}
