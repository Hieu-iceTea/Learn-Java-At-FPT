/**
 * [JavaCore] Exception Handling - Xử lý lỗi ngoại lệ trong Java
 * https://www.codelean.vn/2020/04/javacore-exception-handling-xu-ly-loi.html
 */

package CodeLean.Java1_Exception;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        while (true) {
            try {
                testMyException();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(ex);
                System.out.println();
            }
        }
    }

    public static void testMyException() throws Exception {
        int x;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter x = ");
        x = input.nextInt();

        if (x == 5) {
            throw new Exception("it is Exception, x = 5");
        }

        System.out.println("PASS!!");
    }
}
