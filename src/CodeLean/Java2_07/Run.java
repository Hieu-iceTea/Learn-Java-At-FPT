package CodeLean.Java2_07;

import MyUtilities.Utility;

import java.sql.*;

/**
 * [Java2_07] UPDATE trong MySQL bằng Java
 * http://www.codelean.vn/2020/03/java207-update-trong-mysql-bang-java.html
 */
public class Run {
    public static void main(String[] args) {
        //JdbcUpdateTest();
        //Exercises_1();
        //Exercises_2();
    }

    /**
     * 3.3  Example 3: SQL UPDATE
     */
    private static void JdbcUpdateTest() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/eBookStore?" +
                            "&serverTimezone=UTC" +
                            "&allowPublicKeyRetrieval=true" +
                            "&useSSL=false",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            int IDBook = 1001;

            // Increase the price by 7% and qty by 1 for id=1001
            String queryUpdate = "UPDATE book SET Price = Price * 0.7, Qty = Qty + 1 WHERE IDBook = " + IDBook + ";";
            int countRecordAffected = statement.executeUpdate(queryUpdate);
            System.out.println("Number of records affected: " + countRecordAffected);

            // Issue a SELECT to check the UPDATE
            String querySelect = "SELECT * FROM book WHERE IDBook = " + IDBook + ";";
            ResultSet resultSet = statement.executeQuery(querySelect);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("IDBook") + ", "
                        + resultSet.getString("Name") + ", "
                        + resultSet.getDouble("Price") + ", "
                        + resultSet.getInt("Qty"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * <b>Exercises 1: </b> <br>
     * <b>Viết chương trình Java để thực thi các câu lệnh SQL sau: </b> <br> <br>
     * 1. Tăng price lên 50% cho "A Cup of Java". <br>
     * 2. Set qty là 0 cho "A Teaspoon of Java". <br>
     */
    private static void Exercises_1() {
        // 1. Tăng price lên 50% cho "A Cup of Java".
        String query1 = "UPDATE Book SET Price = Price * 1.5 WHERE Name = 'A Cup of Java';";
        int countRecordAffected1 = Utility.executeUpdate("eBookStore", query1);
        System.out.println("Number of records affected 1: " + countRecordAffected1);

        // 2. Set qty là 0 cho "A Teaspoon of Java".
        String query2 = "UPDATE Book SET Qty =0 WHERE Name = 'A Teaspoon of Java';";
        int countRecordAffected2 = Utility.executeUpdate("eBookStore", query2);
        System.out.println("Number of records affected 2: " + countRecordAffected2);
    }

    /**
     * <b>Exercises 2: </b> <br>
     * <b>Bạn hãy sử dụng Java để thay đổi nội dung trong cơ sở dữ liệu mẫu <i><u>northwind</u></i>, yêu cầu như sau: </b> <br> <br>
     * <b>1.</b> Thay đổi thông tin của loại sản phẩm trong bảng Category, đổi tên category là 'Seafood' thành 'SeaFood VN'. Viết lệnh SELECT để check lại xem nội dung đã được update chưa. <br> <br>
     * <b>2.</b> Thay đổi thông tin địa chỉ của khách hàng Customer, mã khách hàng Customer ID là 'FRANK' , có thông tin địa chỉ mới là '1A Yet Kieu - Ha Noi'. Viết lệnh SELECT để check lại xem nội dung đã được update chưa. <br> <br>
     * <b>3.</b> Thay đổi giá của các sản phẩm trong bảng Proudcts, sản phẩm nào có category là 5,7,8 thì tăng giá lên 10%. Viết lệnh SELECT để check lại xem nội dung đã được update chưa. <br> <br>
     * <b>4.</b> Thay đổi thông tin của đơn đặt hàng trong bảng Orders, thay đổi shipvia của OrderID 10313, order hiện tại có ShipVia là 2 đổi thành 3.
     */
    private static void Exercises_2() {
        //Exercises_2_1();
        //Exercises_2_2();
        //Exercises_2_3();
        //Exercises_2_4();
    }

    private static void Exercises_2_1() {
        // 1. Thay đổi thông tin của loại sản phẩm trong bảng Category, đổi tên category là 'Seafood' thành 'SeaFood VN'.
        // Viết lệnh SELECT để check lại xem nội dung đã được update chưa.

        String queryUpdate = "UPDATE Categories SET CategoryName = 'SeaFood VN' WHERE CategoryName = 'Seafood';";
        int countRecordAffected = Utility.executeUpdate("NorthWind", queryUpdate);
        System.out.println("Number of records affected: " + countRecordAffected);

        try {
            String querySelect = "SELECT * FROM categories;";
            ResultSet resultSet = Utility.executeQuery("NorthWind", querySelect);
            System.out.println("After affected: ");
            System.out.println(String.format("%-12s %-15s %-20s", "CategoryID", "CategoryName", "Description"));
            while (resultSet.next()) {
                System.out.println(String.format("%-12s %-15s %-20s", resultSet.getInt("CategoryID"),
                        resultSet.getString("CategoryName"),
                        resultSet.getString("Description")));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void Exercises_2_2() {
        // 2. Thay đổi thông tin địa chỉ của khách hàng Customer, mã khách hàng Customer ID là 'FRANK' ,
        // có thông tin địa chỉ mới là '1A Yet Kieu - Ha Noi'.
        // Viết lệnh SELECT để check lại xem nội dung đã được update chưa.

        String queryUpdate = "UPDATE customers SET Address = '1A Yet Kieu - Ha Noi' WHERE CustomerID = 'FRANK';";
        int countRecordAffected = Utility.executeUpdate("NorthWind", queryUpdate);
        System.out.println("Number of records affected: " + countRecordAffected);

        try {
            String querySelect = "SELECT * FROM customers;";
            ResultSet resultSet = Utility.executeQuery("NorthWind", querySelect);
            System.out.println("After affected: ");
            System.out.println(String.format("%-12s %-25s %-20s", "CustomerID", "ContactName", "Address"));
            while (resultSet.next()) {
                System.out.println(String.format("%-12s %-25s %-20s", resultSet.getString("CustomerID"),
                        resultSet.getString("ContactName"),
                        resultSet.getString("Address")));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void Exercises_2_3() {
        // Thay đổi giá của các sản phẩm trong bảng Proudcts, sản phẩm nào có category là 5,7,8 thì tăng giá lên 10%.
        // Viết lệnh SELECT để check lại xem nội dung đã được update chưa.

        String queryUpdate = "UPDATE Products SET UnitPrice = UnitPrice * 1.1 WHERE CategoryID in (5, 7, 8);";
        int countRecordAffected = Utility.executeUpdate("NorthWind", queryUpdate);
        System.out.println("Number of records affected: " + countRecordAffected);

        try {
            String querySelect = "SELECT * FROM Products WHERE CategoryID in (5, 7, 8);";
            ResultSet resultSet = Utility.executeQuery("NorthWind", querySelect);
            System.out.println("After affected: ");
            System.out.println(String.format("%-35s %-15s %-20s", "ProductName", "CategoryID", "UnitPrice"));
            while (resultSet.next()) {
                System.out.println(String.format("%-35s %-15s %-20s", resultSet.getString("ProductName"),
                        resultSet.getInt("CategoryID"),
                        resultSet.getDouble("UnitPrice")));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void Exercises_2_4() {
        // Thay đổi thông tin của đơn đặt hàng trong bảng Orders,
        // thay đổi shipvia của OrderID 10313, order hiện tại có ShipVia là 2 đổi thành 3.

        String queryUpdate = "UPDATE orders SET ShipVia = 3 WHERE OrderID = 10313;";
        int countRecordAffected = Utility.executeUpdate("NorthWind", queryUpdate);
        System.out.println("Number of records affected: " + countRecordAffected);

        try {
            String querySelect = "SELECT * FROM orders WHERE OrderID = 10313;";
            ResultSet resultSet = Utility.executeQuery("NorthWind", querySelect);
            System.out.println("After affected: ");
            System.out.println(String.format("%-12s %-15s", "OrderID", "ShipVia"));
            while (resultSet.next()) {
                System.out.println(String.format("%-12s %-15s", resultSet.getInt("OrderID"),
                        resultSet.getString("ShipVia")));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
