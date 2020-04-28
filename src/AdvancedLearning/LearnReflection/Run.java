package AdvancedLearning.LearnReflection;

import CodeLean.Java1_20.Rectangle;
import MyUtilities.Utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;

/**
 * Hiếu tự học reflection <br>
 * 27/04/2020 <br>
 * http://viblo.asia/p/java-reflection-and-anotation-DbmvmWRMeAg
 */
public class Run {
    public static void main(String[] args) {
        try {

            Class class_Rectangle = Class.forName("CodeLean.Java1_20.Rectangle");

            Constructor[] constructors = class_Rectangle.getConstructors();
            for (var item_constructor : constructors) {
                System.out.println("constructor: " + item_constructor);

                Class[] parameterTypes = item_constructor.getParameterTypes();
                for (var item_parameterType : parameterTypes) {
                    System.out.println("parameterType: " + item_parameterType);
                }
                System.out.println(" - - - - - ");
            }

            Constructor constructor = class_Rectangle.getConstructor(double.class, double.class);
            System.out.println("constructor IS: " + constructor);
            Object object_Rectangle = (Rectangle) constructor.newInstance(5, 10);
            System.out.println(object_Rectangle);

            System.out.println("Lấy Type cách 1: " + constructors[0].getParameterTypes()[0]); //Cách này tệ
            System.out.println("Lấy Type cách 2: " + class_Rectangle.getDeclaredField("width").getType());

            //Method method_setWidth = class_Rectangle.getMethod("setWidth", Utility.parseType("double")); //Hoặc: double.class
            Method method_setWidth = class_Rectangle.getMethod("setWidth", class_Rectangle.getDeclaredField("width").getType()); //Hoặc: double.class
            method_setWidth.invoke(object_Rectangle,9999);
            System.out.println(object_Rectangle);

            Method method2 = class_Rectangle.getMethod("setColor", Class.forName("java.lang.String")); //Hoặc: [String.class] đều được

            method2.invoke(object_Rectangle, "Red");
            System.out.println(object_Rectangle);

            //Field field_width = class_Rectangle.getField("width"); //"width" phải là public
            Field field_width = class_Rectangle.getDeclaredField("width");
            field_width.setAccessible(true); // Cho phép để truy cập vào các trường private. Nếu không sẽ bị ngoại lệ IllegalAccessException
            field_width.set(object_Rectangle, 5);
            System.out.println("W : " + object_Rectangle);

            System.out.println("F: " + field_width.get(object_Rectangle));

            System.out.println(" - - - - -");

            Field[] fields = class_Rectangle.getDeclaredFields();
            for (var item : fields) {
                System.out.println("getDeclaredField :" + item.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
