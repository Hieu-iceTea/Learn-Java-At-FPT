package CodeLean.Java2_06;

import CodeLean.Java2_06.GiftShop.GiftView.GiftShop;
import MyUtilities.Utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * [Java2_06] INSERT và DELETE dữ liệu trong MySQL bằng Java
 * https://www.codelean.vn/2020/03/java206-insert-va-delete-du-lieu-trong.html
 */

public class Run {
    public static void main(String[] args) {
        //BaiTap_1();

        GiftShop.main(args); //Đây là BaiTap_2:
    }

    //region Bài Tập 1
    /**
     * <b>Bài tập 1: </b> <br> <br>
     *
     * Sửa đổi chương trình Java của bạn để thực hiện các câu lệnh SQL sau: <br> <br>
     *
     * <b>1.</b> Xóa tất cả sách có id > 8000; <br>
     * <b>2.</b> Thêm cùng lúc 2 bản ghi (8001, 'Java Core', 'Dang Kim Thi', 15.55, 55) và (8002, 'Java Advanced', 'James Gosling', 25.55, 55); <br>
     * <b>3.</b> Thêm 1 cuốn sách có thông tin là (2001, 'Java JDBC MySQL', 'ThiDK'); <br>
     * <b>4.</b> Xoá một cuối sách có id là do người dùng nhập vào, ví dụ id = 2001 <br>
     * <b>5.</b> Thêm mới một cuốn sách có đầy đủ thông tin do người dùng nhập vào từ bàn phím <br>
     */
    private static void BaiTap_1() {
        //BaiTap_1_1();
        //BaiTap_1_2();
        //BaiTap_1_3();
        //BaiTap_1_4();
        //BaiTap_1_5();
    }

    /**
     * <b>1.</b> Xóa tất cả sách có id > 8000; <br>
     */
    private static void BaiTap_1_1() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookstore?" +
                            "&serverTimezone=UTC" +
                            "&allowPublicKeyRetrieval=true" +
                            "&useSSL=false",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            String query = "DELETE FROM book WHERE IDBook > 8000";
            int recordCount = statement.executeUpdate(query);

            System.out.println("Số bản ghi đã xóa là: " + recordCount);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

//        String query = "DELETE FROM book WHERE IDBook > 8000";
//        int recordCount = Utility.executeUpdate("ebookstore", query);
//        System.out.println("Số bản ghi đã xóa là: " + recordCount);
    }

    /**
     * <b>2.</b> Thêm cùng lúc 2 bản ghi (8001, 'Java Core', 'Dang Kim Thi', 15.55, 55) và (8002, 'Java Advanced', 'James Gosling', 25.55, 55); <br>
     */
    private static void BaiTap_1_2() {
        int recordCount = Utility.executeUpdate("eBookStore", "#Nothing");
        System.out.println("Số bản ghi bị ảnh hưởng: " + recordCount);
    }

    /**
     * <b>3.</b> Thêm 1 cuốn sách có thông tin là (2001, 'Java JDBC MySQL', 'ThiDK'); <br>
     */
    private static void BaiTap_1_3() {
        int recordCount = Utility.executeUpdate("eBookStore", "#Nothing");
        System.out.println("Số bản ghi bị ảnh hưởng: " + recordCount);
    }

    /**
     * <b>4.</b> Xoá một cuối sách có id là do người dùng nhập vào, ví dụ id = 2001 <br>
     */
    private static void BaiTap_1_4() {
        System.out.print("Mời nhập vào ID sách cần xóa: ");
        int idBook = Utility.getInputInt();
        int recordCount = Utility.executeUpdate("eBookStore", "DELETE FROM Book WHERE IDBook = " + idBook);
        System.out.println("Số bản ghi bị ảnh hưởng: " + recordCount);
    }

    /**
     * <b>5.</b> Thêm mới một cuốn sách có đầy đủ thông tin do người dùng nhập vào từ bàn phím <br>
     */
    private static void BaiTap_1_5() {
        //IDAuthor, IDCategory, IDPublishCompany, Name, Price, Qty, DatePublish, Description
        System.out.println("Mời nhập các thông tin cho cuốn sách: ");

        System.out.print("Tên sách: ");
        String Name = Utility.getInputLine();

        System.out.print("ID Tác giả (Nhập 0 để hiện danh sách tác giả): ");
        int IDAuthor = Utility.getInputInt();
        if (IDAuthor == 0) {
            IDAuthor = choseIDFromTable("Author");
        }

        System.out.print("ID Thể loại (Nhập 0 để hiện danh sách thể loại): ");
        int IDCategory = Utility.getInputInt();
        if (IDCategory == 0) {
            IDCategory = choseIDFromTable("Category");
        }

        System.out.print("ID Nhà phát hành (Nhập 0 để hiện danh sách nhà phát hành): ");
        int IDPublishCompany = Utility.getInputInt();
        if (IDPublishCompany == 0) {
            IDPublishCompany = choseIDFromTable("PublishCompany");
        }

        System.out.print("Giá bán: ");
        Double Price = Utility.getInputDouble();

        System.out.print("Số lượng trong kho hiện tại: ");
        int Qty = Utility.getInputInt();

        System.out.print("Ngày phát hành (yyyy-mm-dd): ");
        String DatePublish = Utility.getInputLine();

        System.out.print("Mô tả về sách: ");
        String Description = Utility.getInputLine();

        String query = "INSERT INTO Book (IDAuthor, IDCategory, IDPublishCompany, Name, Price, Qty, DatePublish, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled) " +
                "VALUES (" + IDAuthor + ", " + IDCategory + ", " + IDPublishCompany + ", '" + Name + "', " + Price + ", " + Qty + ", '" + DatePublish + "', '" + Description + "', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, TRUE);";
        System.out.println("Câu query của bạn là: \n" +query);

        int recordCount = Utility.executeUpdate("eBookStore", query);
        System.out.println("Số bản ghi bị ảnh hưởng: " + recordCount);
    }

    /**
     * Common Method
     * @param tableName
     * @return
     */
    private static int choseIDFromTable(String tableName) {
        try {
            int ID;
            ResultSet resultSet = Utility.executeQuery("eBookStore",
                    "SELECT ID" + tableName + ", Name FROM " + tableName + " WHERE Enabled = TRUE");
            System.out.println("ID\t\tName");
            List<Integer> lstIDAuthor = new ArrayList<>();
            int recordCount = 0;
            while (resultSet.next()) {
                lstIDAuthor.add(resultSet.getInt("ID" + tableName));
                System.out.print(resultSet.getInt("ID" + tableName) + ".\t\t");
                System.out.println(resultSet.getString("Name"));
                ++recordCount;
            }
            if (recordCount == 0) {
                System.out.println("[ERROR] Danh sách trống.");
                return -1;
            }
            System.out.print("Bạn chọn ID: ");
            ID = Utility.getInputInt();
            while (!lstIDAuthor.contains(ID)) {
                System.out.println("Bạn nhập ID không có trong danh sách trên, mời nhập lại!");
                System.out.print("Bạn chọn ID: ");
                ID = Utility.getInputInt();
            }
            return ID;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return -1;
    }
    //endregion
}
