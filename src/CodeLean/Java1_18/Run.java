/**
 * [Java1_18] Polymorphism - Tính Đa Hình Trong Java
 * https://www.codelean.vn/2020/03/jp09-polymorphism-tinh-hinh-trong-java.html
 */

package CodeLean.Java1_18;

public class Run {
    public static void main(String[] args) {
        testCircle();
    }

    public static void testCircle() {
        Circle c1 = new Cylinder(1.1, 2.2);
        Cylinder c2 = new Cylinder(5.5, 8.8);

        System.out.println(c1);
        System.out.println(c2);

        System.out.println(c1.getClass());
        System.out.println(c2.getClass());

        System.out.println(((Cylinder) c1).getHeight());
        System.out.println(c2.getHeight());
        System.out.println(c1 instanceof  Circle);

        Circle c3 = new Cylinder(1.1, 2.2); //Pass
        Cylinder c4 = (Cylinder) c3;

        Circle c5 = new Cylinder(1.1, 8); //Pass
        Cylinder c6 = (Cylinder) new Circle(1.1); //Fail

        /** => SUMMARY: A subclass object can be substituted for its superclass, but the reverse is not true. */
    }
}
