/**
 * [Java1_16] Thừa Kế Trong Java
 * https://www.codelean.vn/2020/03/jp07-thua-ke-trong-java.html
 */

package CodeLean.Java1_16;

public class Run {
    public static void main(String[] args) {
        //testCylinder();
        //testPoint3D();
        testPerson();
    }

    private static void testCylinder() {
        System.out.println("Look Good! This is Cylinder.");

        Cylinder cylinder1 = new Cylinder(5, 2, "Red");

        System.out.println(cylinder1);

        System.out.println( "Color is " + cylinder1.getColor()
                + ", Radius is " + cylinder1.getRadius()
                + ", Height is " + cylinder1.getHeight()
                + ", Color is " + cylinder1.getColor()
                + ", Base area is " + cylinder1.getArea()
                + ", Volume is " + cylinder1.getVolume());
    }

    private static void testPoint3D() {
        Point3D point3D = new Point3D(6, 8, 9);
        System.out.println(point3D);

        Point3D point3D_2 = new Point3D();
        point3D_2.setX(5);
        point3D_2.setY(10);
        point3D_2.setZ(15);
        System.out.println(point3D_2);
    }

    private static void testPerson() {
        /** Test Student class */
        Student student1 = new Student("Nguyễn Đình Hiếu", "Vinh, Nghệ An");
        System.out.println(student1);

        student1.addCourseGrade("Java bassic", 9);
        student1.addCourseGrade("Java Aven", 8);
        student1.printGrades();
        System.out.println("Average is " + student1.getAverageGrade());

        /** Test Teacher class */
        Teacher teacher1 = new Teacher("Đặng Kim Thi", "Hà Nội");
        System.out.println(teacher1);
        System.out.println(teacher1.addCourse("Java bassic"));
        System.out.println(teacher1.addCourse("Java bassic"));

        System.out.println(teacher1.removeCourse("Java bassic"));
        System.out.println(teacher1.removeCourse("Java bassic"));
    }
}
