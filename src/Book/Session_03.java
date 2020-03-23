package Book;

import java.util.Scanner;

public class Session_03 {

    enum Direction {
        East, North, South, West
    }

    public static void main(String[] args) {

        //Code Snippet 1:
        //int rollNumber;
        //char gender;

        //Code Snippet 2:
        int rollNumber = 101;
        char gender = 'M';

        //Code Snippet 3:
        //int rollNumber; // Variable is declared
        //rollNumber = 101; //variable is initialized

        //Code Snippet 4:
        // Declares three integer variables x, y, and z
        // int x, y, z;
        // Declares three integer variables, initializes a and c
        // int a = 5, b, c = 10;
        // Declares a byte variable num and initializes its value to 20
        // byte num = 20;
        // Declares the character variable c with value ‘c’
        // char c = ‘c’;
        // Stores value 10 in num1 and num2
        // int num1 = num2 = 10;

        //Enum
        Direction tmpDirection;
        tmpDirection = Direction.East;
        System.out.println("Value: " + tmpDirection);


        System.out.printf("pi =  %5.3f, e =  %5.4f %n", Math.PI, Math.E);

        int num = 2;
        double result = num * num;
        System.out.format("The square root of %d is %f.%n", num, result);

        testScanner();
    }

    public static void testScanner (){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int intValue = s.nextInt();

        System.out.println("Enter a string: ");
        String strValue = s.next();

        System.out.println("intValue: " + intValue + "\nstrValue: " + strValue);
    }
}
