package CodeLean;

public class Java_05 {
    public static void main(String[] args) {
        //checkPassFail();
        //checkOddEven();
        //reverseInt();

        Arithmetic(new String[] {"6", "5", "+"});
    }

    public static void checkPassFail(){
        int mark = 45;
        System.out.println("The mark is: " + mark);

        if (mark >= 50){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println("Done!");
    }

    public static void checkOddEven() {
        int number = 45;
        System.out.println("The number is: " + number);

        if (number % 2 == 0){
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }

        System.out.println("Bye!");
    }

    public static void reverseInt(){
        int inNumber = 12345;
        int outNumber = 0;
        int digit;

        /*
        while (inNumber > 0){ //Cách 1
            digit = inNumber % 10;
            outNumber = outNumber * 10 + digit;
            inNumber /= 10;
        }
        */

        while (inNumber > 0){ //Cách 2
            digit = inNumber % 10;
            String tmpStr = outNumber + "" + digit;
            outNumber = Integer.parseInt(tmpStr);
            inNumber /= 10;
        }

        System.out.println("out Number: " + outNumber);
    }

    public static void Arithmetic(String[] args){ //Bài này không làm đúng được với yêu cầu (bỏ qua)
        int operand1, operand2;
        char theOperator;

        if (args.length != 3){
            System.err.println("Usage: java Arithmetic int1 int2 op");
            return;
        }

        operand1 = Integer.parseInt(args[0]);
        operand2 = Integer.parseInt(args[1]);
        theOperator = args[2].charAt(0);

        switch (theOperator){
            case '+':
                System.out.println("Sum = " + (operand1 + operand2));
                break;
            case '-':
                System.out.println("Sub = " + (operand1 - operand2));
                break;
            case '*':
                System.out.println("Mul = " + (operand1 * operand2));
                break;
            case '/':
                System.out.println("Div = " + (operand1 / operand2));
                break;
            default:
                System.out.println("inValid Operator!");
                break;
        }
    }
}
