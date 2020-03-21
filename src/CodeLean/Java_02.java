package CodeLean;

public class Java_02 {
    public static void main(String[] args) {

        //1. Bắt đầu với chương trình java đầu tiên
        HelloWorld();

        //6. Xuất ra thông qua System.out.println() & System.out.print()
        PrintPattern();

        //7. Hãy viết một chương trình để thêm một vài số
        IntegerSum();

        //8. Chương trình
        double area = RectangleComputation(10, 10); //Tính diện tích hình chữ nhật
        System.out.println("Area = " + area);
    }

    public static void HelloWorld(){
        System.out.println("Hello world");
    }

    public static void PrintPattern(){
        System.out.println(
                "* * * * *      * * * * *    * * * * *        *\n" +
                        " * * * * *     *       *     *     *     * *   * *\n" +
                        "* * * * *      *       *      *   *         * *\n" +
                        " * * * * *     *       *       * *         *   *\n" +
                        "* * * * *      * * * * *        *         *     *\n" +
                        "   (a)            (b)          (c)           (d)");

        System.out.println(
                "          '__'\n" +
                        "          (oo)\n" +
                        "  /========//\n" +
                        " / || @@ ||\n" +
                        "*  ||----||\n" +
                        "   VV    VV\n" +
                        "   ''    ''");
    }

    public static void IntegerSum(){
        int num1 = 50;
        int num2 = 25;
        int num3 = 30;
        int sum = num1 + num2 + num3;
        System.out.println("SUM = " + sum);
    }

    public static double RectangleComputation(double length, double width){
        return length * width;
    }
}
