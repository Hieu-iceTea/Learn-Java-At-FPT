package Book;

import java.util.Objects;
import java.util.Scanner;

public class Session_05 {
    //Looping ConstructsS
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        int num = getInputInt();
        System.out.print("Sum of all digits: " + sumOfAllDigits(num));

        //Menu();
    }

    public static void Menu(){
        boolean condition = true;
        while (condition){
            System.out.print("- - - - - - \nMENU\n" +
                    "1. View\n" +
                    "2. Edit\n" +
                    "0. ~ EXIT\n" +
                    "Your Chose: ");
            int chose = getInputInt();
            switch (chose){
                case 1:
                    System.out.println("You chose [View]");
                    condition = getConfirm();
                    break;
                case 2:
                    System.out.println("You chose [Edit]");
                    condition = getConfirm();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid!");
                    condition = getConfirm();
                    break;
            }
        }
    }

    public static int getInputInt(){
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public static boolean getConfirm(){
        System.out.print("Do you want to continue? (Y/N): ");

        Scanner input = new Scanner(System.in);
        String str = input.next();

        return str.equals("y") || Objects.equals(str, "Y");
    }

    public static int  sumOfAllDigits(int num){
        int sum = 0;

        while (num != 0){
            sum = sum + num % 10;
            num = num / 10;
        }

        return sum;
    }
}
