package Book;

import java.util.Scanner;

public class Session_04 {
    public static void main(String[] args) {
        CodeSnippet_1();
        CodeSnippet_5();
    }

    public static void CodeSnippet_1(){
        int firt = 400, second = 700;
        int result = firt + second;

        if (result > 1000){
            second = second + 100;
        }

        System.out.println("Value is: " + second);
    }

    public static  void  CodeSnippet_5(){
        int num;
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        num = input.nextInt();

        System.out.println("Num = " + num);

        if (num >= 90)
            System.out.println("Verry Good (A+)");
        else if (num >= 80)
            System.out.println("Good (A)");
        else if (num >= 60)
            System.out.println("Great (B)");
    }
}
