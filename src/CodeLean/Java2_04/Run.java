package CodeLean.Java2_04;

import java.sql.*;

/**
 * <b>[Java2_04] Kết Nối và Truy Vấn dữ liệu trong MySQL bằng Java</b> <br>
 * > https://www.codelean.vn/2020/03/java204-ket-noi-va-truy-van-du-lieu.html <br>
 * @since 15:30 17/04/2020
 */
public class Run {
    public static void main(String[] args) {
        //JdbcSelectTest();

        //Exercises_1_1();
        //Exercises_1_2();
        //Exercises_1_3();

        //Exercises_2();
    }

    private static void JdbcSelectTest() {
        try {
            // Step 1: Allocate a database 'Connection' object
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookshop?" +
                            "&allowPublicKeyRetrieval=true" +
                            "&useSSL=false" +
                            "&serverTimezone=UTC",
                    "root",
                    "");
            // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

            // Step 2: Allocate a 'Statement' object in the Connection
            Statement statement = connection.createStatement();

            // Step 3: Execute a SQL SELECT query. The query result is returned in a 'ResultSet' object.
            String strQuery = "SELECT title, price, qty FROM books";

            ResultSet resultSet = statement.executeQuery(strQuery);

            // Step 4: Process the ResultSet by scrolling the cursor forward via next().
            int count = 0;
            String strResult = "";
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                int qty = resultSet.getInt("qty");
                strResult += "title: " + title + " | price: " + price + " | qty: " + qty + "\n";
                ++count;
            }

            System.out.println("The records selected are:");
            System.out.println(strResult);

            System.out.println("Total number of records: " + count);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void Exercises_1_1() {
        //Exercises 1:
        //Các bạn làm bài tương tự để thực hiện hiển thị kết quả của những câu lệnh SELECT sau.
        //SELECT * FROM books

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookshop?" +
                            "&serverTimezone=UTC" +
                            "&allowPublicKeyRetrieval=true" +
                            "&useSSL=false",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            String result = "";

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String price = resultSet.getString("price");
                String qty = resultSet.getString("qty");

                result += "id: " + id +
                        " | title: " + title +
                        " | author: " + author +
                        " | price: " + price +
                        " | qty: " + qty + "\n";
            }

            System.out.println("Kết quả truy vấn là:\n" + result);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void Exercises_1_2() {
        //SELECT title, price FROM books WHERE author = 'CodeLean VN'

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookshop?" +
                            "&serverTimezone=UTC" +
                            "&useSSL=false" +
                            "&allowPublicKeyRetrieval=true",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            String query = "SELECT title, price FROM books " +
                    "WHERE author = 'CodeLean VN'";
            ResultSet resultSet = statement.executeQuery(query);

            String result = "";
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String price = resultSet.getString("price");
                result += "title: " + title + ", price: " + price + "\n";
            }
            System.out.println("Kết quả truy vấn của [" + query + "] là: ");
            System.out.println(result);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void Exercises_1_3() {
        //SELECT title, author, price, qty FROM books WHERE author = 'CodeLean VN' OR price >= 30 ORDER BY price DESC, id ASC

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookshop?" +
                            "&serverTimezone=UTC" +
                            "&useSSL=false" +
                            "&allowPublicKeyRetrieval=true",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            String query = "SELECT title, author, price, qty\n" +
                    "FROM books\n" +
                    "WHERE author = 'CodeLean VN' OR price >= 30\n" +
                    "ORDER BY price DESC, id ASC";
            ResultSet resultSet = statement.executeQuery(query);

            String result = "";
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String price = resultSet.getString("price");
                String qty = resultSet.getString("qty");

                result += "title: " + title + ", author: " + author + ", price: " + price + ",qty: " + qty + "\n";
            }

            System.out.println("Kết quả truy vấn: ");
            System.out.println(result);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void Exercises_2() {
        //Các bạn sử dụng cơ sở dữ liệu Northwind để thực hiện hiển thị các thông tin sau:
        //1. Hiển thị danh sách khách hàng
        //2. Tìm khách hàng theo tên
        //3. Hiển thị danh sách sản phẩm
        //4. Tìm sản phẩm theo giá bán trong khoảng do người dùng nhập vào
        //5. Hiển thị thông tin chi tiết của một đơn hàng

        //showCustomers();
        //findCustomerByName("af");
        //showProducts();
        //findProductsByPrice(50, 100);
        //showOrderDetailsByOrderID(10248);
    }

    // Function Method
    private static void showCustomers() {
        ResultSet resultSet = getResultSet_FromDataBase("northwind", "SELECT * FROM customers");
        printListCustomer_FromResultSet(resultSet);
    }

    private static void findCustomerByName(String customerName) {
        String query = "SELECT * FROM customers WHERE ContactName like '%" + customerName + "%'";
        ResultSet resultSet = getResultSet_FromDataBase("northwind", query);
        printListCustomer_FromResultSet(resultSet);
    }

    private static void showProducts() {
        ResultSet resultSet = getResultSet_FromDataBase("northwind", "SELECT * FROM products");
        printListProduct_FromResultSet(resultSet);
    }

    private static void findProductsByPrice(double priceFrom, double priceTo) {
        String query = "SELECT * FROM products WHERE UnitPrice > " + priceFrom + " AND UnitPrice < " + priceTo;
        ResultSet resultSet = getResultSet_FromDataBase("northwind", query);
        printListProduct_FromResultSet(resultSet);
    }

    private static void showOrderDetailsByOrderID(int OrderID) {
        try {
            ResultSet resultSet_Order = getResultSet_FromDataBase("northwind", "SELECT * FROM orders WHERE OrderID = " + OrderID);
            ResultSet resultSet_orderDetailsExtended = getResultSet_FromDataBase("northwind", "SELECT  * FROM `order details extended` WHERE OrderID = " + OrderID);

            String strResutl_Order = "";
            while (resultSet_Order.next()) {
                //String OrderID = resultSet_Order.getString("");
                String CustomerID = resultSet_Order.getString("CustomerID");
                String EmployeeID = resultSet_Order.getString("EmployeeID");
                String OrderDate = resultSet_Order.getString("OrderDate");
                String RequiredDate = resultSet_Order.getString("RequiredDate");
                String ShippedDate = resultSet_Order.getString("ShippedDate");
                String ShipVia = resultSet_Order.getString("ShipVia");
                String Freight = resultSet_Order.getString("Freight");
                String ShipName = resultSet_Order.getString("ShipName");
                String ShipAddress = resultSet_Order.getString("ShipAddress");
                String ShipCity = resultSet_Order.getString("ShipCity");
                String ShipRegion = resultSet_Order.getString("ShipRegion");
                String ShipPostalCode = resultSet_Order.getString("ShipPostalCode");
                String ShipCountry = resultSet_Order.getString("ShipCountry");

                strResutl_Order += "OrderID" +
                        ", CustomerID: " + CustomerID +
                        ", EmployeeID: " + EmployeeID +
                        ", OrderDate: " + OrderDate +
                        ", RequiredDate: " + RequiredDate +
                        ", ShippedDate: " + ShippedDate +
                        ", ShipVia: " + ShipVia +
                        ", Freight: " + Freight +
                        ", ShipName: " + ShipName +
                        ", ShipAddress: " + ShipAddress +
                        ", ShipCity: " + ShipCity +
                        ", ShipRegion: " + ShipRegion +
                        ", ShipPostalCode: " + ShipPostalCode +
                        ", ShipCountry: " + ShipCountry + "\n";
            }

            System.out.println("Đơn hàng có ID = " + OrderID + ": ");
            System.out.println(strResutl_Order);

            String strResult_OrderDetailExtended = "";
            while (resultSet_orderDetailsExtended.next()) {

                String ProductID = resultSet_orderDetailsExtended.getString("ProductID");
                String ProductName = resultSet_orderDetailsExtended.getString("ProductName");
                String UnitPrice = resultSet_orderDetailsExtended.getString("UnitPrice");
                String Quantity = resultSet_orderDetailsExtended.getString("Quantity");
                String Discount = resultSet_orderDetailsExtended.getString("Discount");
                String ExtendedPrice = resultSet_orderDetailsExtended.getString("ExtendedPrice");

                strResult_OrderDetailExtended += "\tProductID: " + ProductID +
                        ", ProductName: " + ProductName +
                        ", UnitPrice: " + UnitPrice +
                        ", Quantity: " + Quantity +
                        ", Discount: " + Discount +
                        ", ExtendedPrice: " + ExtendedPrice +"\n";
            }
            System.out.println("> CHi tiết đơn hàng: ");
            System.out.println(strResult_OrderDetailExtended);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Common Method
    private static ResultSet getResultSet_FromDataBase(String databaseName, String query) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + databaseName + "?" +
                            "&serverTimezone=UTC" +
                            "&useSSL=false" +
                            "&allowPublicKeyRetrieval=true",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static void printListCustomer_FromResultSet(ResultSet resultSet) {
        try {
            String strResult = "";
            while (resultSet.next()) {
                String CustomerID = resultSet.getString("CustomerID");
                String CompanyName = resultSet.getString("CompanyName");
                String ContactName = resultSet.getString("ContactName");
                String ContactTitle = resultSet.getString("ContactTitle");
                String Address = resultSet.getString("Address");
                String City = resultSet.getString("City");
                String Region = resultSet.getString("Region");
                String PostalCode = resultSet.getString("PostalCode");
                String Country = resultSet.getString("Country");
                String Phone = resultSet.getString("Phone");
                String Fax = resultSet.getString("Fax");

                strResult += "CustomerID: " + CustomerID +
                        ", CompanyName: " + CompanyName +
                        ", ContactName: " + ContactName +
                        ", ContactTitle: " + ContactTitle +
                        ", Address: " + Address +
                        ", City: " + City +
                        ", Region: " + Region +
                        ", PostalCode: " + PostalCode +
                        ", Country: " + Country +
                        ", Phone: " + Phone +
                        ", Fax: " + Fax + "\n";
            }

            System.out.println("Kết quả truy vấn: [Danh sách khách hàng]");
            System.out.println(strResult);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void printListProduct_FromResultSet(ResultSet resultSet) {
        try {
            String strResult = "";
            while (resultSet.next()) {
                String ProductID = resultSet.getString("ProductID");
                String ProductName = resultSet.getString("ProductName");
                String SupplierID = resultSet.getString("SupplierID");
                String CategoryID = resultSet.getString("CategoryID");
                String QuantityPerUnit = resultSet.getString("QuantityPerUnit");
                String UnitPrice = resultSet.getString("UnitPrice");
                String UnitsInStock = resultSet.getString("UnitsInStock");
                String UnitsOnOrder = resultSet.getString("UnitsOnOrder");
                String ReorderLevel = resultSet.getString("ReorderLevel");
                String Discontinued = resultSet.getString("Discontinued");

                strResult += "ProductID: " + ProductID +
                        ", ProductName: " + ProductName +
                        ", SupplierID: " + SupplierID +
                        ", CategoryID: " + CategoryID +
                        ", QuantityPerUnit: " + QuantityPerUnit +
                        ", UnitPrice: " + UnitPrice +
                        ", UnitsInStock: " + UnitsInStock +
                        ", UnitsOnOrder: " + UnitsOnOrder +
                        ", ReorderLevel: " + ReorderLevel +
                        ", Discontinued: " + Discontinued + "\n";
            }

            System.out.println("Kết quả truy vấn [Danh sách sản phẩm] :");
            System.out.println(strResult);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}