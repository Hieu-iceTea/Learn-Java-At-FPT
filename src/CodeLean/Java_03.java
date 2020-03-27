package CodeLean;

import javax.swing.JOptionPane;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Java_03 {
    public static void main(String[] args) throws FileNotFoundException {
        //part_4_9();
        //file();
        //file_tryCach();
        //file_format();
        //inputViaDialog();
        //test_Console();
    }

    public static void part_4_9() {
        int x, y;
        x = 5;
        y = ++x;

        int a, b;
        a = 5;
        b = a++;

        System.out.println("y = " + y);
        System.out.println("b = " + b);
    }

    public static void file()
            throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File("text.txt"));

        /*
        int anInt = inputFile.nextInt();
        double aDouble = inputFile.nextDouble();
        String str = inputFile.next();
        String line = inputFile.nextLine();
        */

        int num1 = 0;
        double num2 = 0;
        String name = "0";

        num1 = inputFile.nextInt();
        num2 = inputFile.nextDouble();
        name = inputFile.next();
        System.out.printf("Hi %s, the sum of %d and %.2f is %.2f%n", name, num1, num2, num1 + num2);

        inputFile.close();
    }

    public static void file_tryCach(){
        int num1;
        double num2;
        String name;

        try {
            Scanner inputFile = new Scanner(new File("text.txt"));

            num1 = inputFile.nextInt();
            num2 = inputFile.nextDouble();
            name = inputFile.next();
            System.out.printf("Hi %s, the sum of %d and %.2f is %.2f%n", name, num1, num2, num1 + num2);

            inputFile.close();
        } catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

    }

    public static void file_format()
            throws FileNotFoundException {
        Formatter out = new Formatter(new File("textOut.txt"));

        int num1 = 1234;
        double num2 = 55.66;
        String name = "Hieu_iceTea";

        out.format("Hi %s,%n", name);
        out.format("the sum of %d and %.2f is %.2f%n", num1, num2, num1 + num2);

        out.close();

        System.out.println("Write Done!");
    }

    public static void inputViaDialog(){
        String strRadius;
        double radius, area;

        boolean isValidInput = false;

        while (!isValidInput){
            strRadius = JOptionPane.showInputDialog("Enter the radius of the circle: ");

            if (!strRadius.isEmpty()){
                isValidInput = true;
                radius = Double.parseDouble(strRadius);
                area = radius * radius * Math.PI;

                //System.out.println("The area is " + area);
                JOptionPane.showMessageDialog(null, "The area is: " + area);
            }
        }


    }

    private static void test_Console() {
        /*
        Console con = System.console();
        String inLine;
        inLine = con.readLine("Enter: ");
        */

        /*
        Scanner in = new Scanner(con.reader());
        int anInt = in.nextInt();
        double aDouble = in.nextDouble();
        String str = in.next();
        String line = in.nextLine();
        */

        Console con = System.console();

        if (con == null){
            System.err.println("Console Object is not available.");
            System.exit(1);
        }

        String name = con.readLine("Enter your name: ");
        con.printf("Hello %s%n", name);
    }
}
