package CodeLean.Java2_08;

import MyUtilities.Utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * [Java2_08] eBookStore Online: Book Manager, Customer Manager <br>
 * https://www.codelean.vn/2020/03/java208-ebookstore-online-book-manager.html
 */
public class Run {
    public static void main(String[] args) {
        while (true) {
            System.out.print("\n _ _ _ MENU _ _ _ \n" +
                    "1. Quản lý tài khoản \n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Quẩn ly khách hàng\n" +
                    "0. THOÁT. \n" +
                    "  => Bạn chọn: ");
            int chose = Utility.getInputInt();
            System.out.println(" _ _ _ _ _ _ _ _ ");

            switch (chose) {
                case 1:
                    QuanLyTaiKhoan();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 2:
                    QuanLySanPham();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 3:
                    QuanLyKhachHang();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 0:
                    if (Utility.isConfirm("Xác nhận thoát?")) {
                        System.exit(1);
                    }
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    Utility.pause_PressEnterToContinue();
                    break;
            }
        }
    }

    //region Quản Lý Tài Khoản
    /**
     * 4. Xây dựng chức năng Đăng Ký, Đăng Nhập
     */
    private static void QuanLyTaiKhoan() {
        while (true) {
            System.out.print("\n _ _ _ Quản Lý Tài Khoản _ _ _ \n" +
                    "1. Đăng Ký \n" +
                    "2. Đặng nhập\n" +
                    "0. THOÁT. \n" +
                    "  => Bạn chọn: ");
            int chose = Utility.getInputInt();
            System.out.println(" _ _ _ _ _ _ _ _ ");

            switch (chose) {
                case 1:
                    DangKy();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 2:
                    boolean isLogin = DangNhap();
                    if (isLogin) {
                        System.out.println("Đăng nhập thành công");
                    } else {
                        System.out.println("Sai tài khoản hoặc mật khẩu");
                    }
                    Utility.pause_PressEnterToContinue();
                    break;
                case 0:
                    if (Utility.isConfirm("Xác nhận thoát?")) {
                        System.exit(1);
                    }
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    Utility.pause_PressEnterToContinue();
                    break;
            }
        }
    }

    private static void DangKy() {
        System.out.println("Enter info to register an account");

        System.out.print("UserName: ");
        String UserName = Utility.getInputLine();
        while (!Utility.stripAccents(UserName.replaceAll(" ", "")).equals(UserName) || UserName.isBlank()) {
            System.out.print("Input invalid. Retype: ");
            UserName = Utility.getInputLine();
        }

        System.out.print("Password: ");
        String Password = Utility.getInputLine();
        while (!Utility.stripAccents(Password.replaceAll(" ", "")).equals(Password) || Password.isBlank()) {
            System.out.print("Input invalid. Retype: ");
            Password = Utility.getInputLine();
        }

        System.out.print("Role ");
        System.out.print("(1. Host | 2. Admin | 3. Customer): ");
        int Role = Utility.getInputInt();
        while (Role != 1 && Role != 2 && Role != 3) {
            System.out.print("Input invalid. Retype: ");
            Role = Utility.getInputInt();
        }

        System.out.print("Name: ");
        String Name = Utility.getInputLine();

        System.out.print("Email: ");
        String Email = Utility.getInputLine();

        if (Utility.isConfirm("Xác nhận đăng ký tài khoản mới?")) {
            String query = "INSERT INTO user (UserName, Password, Role, Name, Email, CreatedBy, UpdatedBy, " +
                    "CreatedDate, UpdatedDate, Enabled)\n" +
                    "VALUES ('" + UserName + "', '" + Password + "', " + Role + ", '" + Name + "', '" + Email +
                    "', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true);";
            int countRecordAffected = Utility.executeUpdate("eBookStore", query);

            if (countRecordAffected == 1) {
                System.out.println("Đăng ký thành công! Kiểm tra Email của bạn để xác nhận.");
            } else {
                System.out.println("[ERROR] Có lỗi trong quá trình đăng ký, vui lòng kiểm tra lại thông tin nhập vào");
            }
        }
    }

    /**
     * - Bạn xây dựng tính năng login. Người dùng sẽ nhập username, password và bạn sẽ kiểm tra xem login ok không.
     * @return
     */
    private static boolean DangNhap() {
        System.out.println("Enter info to login an account");

        System.out.print("UserName: ");
        String UserName = Utility.getInputLine();
        while (!Utility.stripAccents(UserName.replaceAll(" ", "")).equals(UserName) || UserName.isBlank()) {
            System.out.print("Input invalid. Retype: ");
            UserName = Utility.getInputLine();
        }

        System.out.print("Password: ");
        String Password = Utility.getInputLine();
        while (!Utility.stripAccents(Password.replaceAll(" ", "")).equals(Password) || Password.isBlank()) {
            System.out.print("Input invalid. Retype: ");
            Password = Utility.getInputLine();
        }

        String query = "SELECT IdUser FROM user WHERE UserName = '" + UserName + "' AND Password = '" + Password + "'";
        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        int countRecord = 0;

        try {
            while (resultSet.next()) {
                ++countRecord;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return countRecord == 1;
    }

    /**
     * - Bạn xây dựng tính năng cho phép người dùng đăng ký:
     * nhập thông tin username, password, Role. (id tự sinh).
     * Sau khi người dùng nhập thông tin thì bạn cần insert vào cơ sở dữ liệu và hiển thị kết quả cho người dùng..
     */
    //endregion

    //region Quản Lý Sản Phẩm
    /**
     * <b>5. Xây dựng tính năng Quản Lý Sản Phẩm </b> <br>
     * Bạn cần xây dựng hệ thống quản lý sách: <br> <br>
     * <b>Thêm:</b> id, name, price, qty, author <br>
     * <b>Sửa:</b> người dùng nhập id, chỉnh sửa thông tin gồm price, qty của sách <br>
     * <b>Xoá:</b> người dùng nhập id sách, xoá thông tin ra khỏi hệ thống (nếu đã có thông tin trong bảng đơn hàng chi tiết thì không được xoá) <br>
     * <b>Hiển thị</b> danh sách sách (top 100 cuốn) <br>
     */
    private static void QuanLySanPham() {
        while (true) {
            System.out.print("\n _ _ _ Quản Lý Sản Phẩm _ _ _ \n" +
                    "1. Thêm sản phẩm\n" +
                    "2. Sửa sản phẩm\n" +
                    "3. Xoá sản phẩm\n" +
                    "4. Hiện thị sản phẩm\n" +
                    "0. THOÁT. \n" +
                    "  => Bạn chọn: ");
            int chose = Utility.getInputInt();
            System.out.println(" _ _ _ _ _ _ _ _ ");

            switch (chose) {
                case 1:
                    themSanPham();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 2:
                    suaSanPham();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 3:
                    xoaSanPham();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 4:
                    hienThiSanPham();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 0:
                    if (Utility.isConfirm("Xác nhận thoát?")) {
                        System.exit(1);
                    }
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    Utility.pause_PressEnterToContinue();
                    break;
            }
        }
    }

    private static void themSanPham() {
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

        int countRecordAffected = Utility.executeUpdate("eBookStore", query);
        System.out.println("Số bản ghi bị ảnh hưởng: " + countRecordAffected);
    }

    private static void suaSanPham() {
        System.out.print("Enter IDBook: ");
        int IDBook = Utility.getInputInt();

        System.out.print("Enter Price: ");
        double Price = Utility.getInputDouble();

        System.out.print("Enter Qty: ");
        int Qty = Utility.getInputInt();

        String query = "UPDATE Book SET Price = " + Price + ", Qty = " + Qty + " WHERE IDBook = " + Qty + ";";
        int countRecordAffected = Utility.executeUpdate("eBookStore", query);
        System.out.println("Number record affected: " + countRecordAffected);
    }

    private static void xoaSanPham() {
        System.out.print("Enter IDBook to delete: ");
        int IDBook = Utility.getInputInt();

        //Kiểm tra sách cần xoá có thông tin trong bản OrderDetail không:
        String querySelect = "SELECT IDBook FROM orderdetail WHERE IDBook = " + IDBook + ";";
        ResultSet resultSet = Utility.executeQuery("eBookStore", querySelect);

        try {
            while (resultSet.next()) {
                System.out.println("Không thể xoá do có thông tin trong bảng OrderDetail");
                return;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        String queryUpdate = "DELETE FROM book WHERE IDBook = " + IDBook;
        int countRecordAffected = Utility.executeUpdate("eBookStore", queryUpdate);
        System.out.println("Number record affected: " + countRecordAffected);
    }

    private static void hienThiSanPham() {
        String query = "SELECT * FROM Book LIMIT 100;";
        ResultSet resultSet = Utility.executeQuery("eBookStore", query);

        System.out.println("Results: ");

        try {
            while (resultSet.next()) {
                System.out.println(
                        String.format("%-5s %-5s %-5s %-5s %-82s %-10s %-5s %-12s %-280s %-12s %-12s %-8s %-8s %-5s",
                                resultSet.getInt("IDBook"),
                                resultSet.getInt("IDAuthor"),
                                resultSet.getInt("IDCategory"),
                                resultSet.getInt("IDPublishCompany"),
                                resultSet.getString("Name"),
                                resultSet.getDouble("Price"),
                                resultSet.getInt("Qty"),
                                resultSet.getString("DatePublish"),
                                resultSet.getString("Description"),
                                resultSet.getString("CreatedBy"),
                                resultSet.getString("UpdatedBy"),
                                resultSet.getString("CreatedDate"),
                                resultSet.getString("UpdatedDate"),
                                resultSet.getString("Enabled")));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
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

    //region Quản Lý Khách Hàng
    /**
     * <b>6. Xây dựng tính năng Quản Lý Khách Hàng </b> <br>
     * Bạn cần xây dựng hệ thống quản lý khách hàng: <br> <br>
     * <b>Thêm:</b> id, name, email, phone, address, level  <br>
     * <b>Sửa:</b> ngời dùng nhập id khách hàng, chỉnh sửa thông tin email, phone, level  <br>
     * <b>Xoá:</b> người dùng nhập id khách hàng, xoá thông tin ra khỏi hệ thống (nếu đã có thông tin trong bảng đơn hàng thì không được xoá)  <br>
     * <b>Hiển thị</b> danh sách khách hàng  (top 100 khách hàng )  <br>
     */
    private static void QuanLyKhachHang() {
        //themKhachHang();
        //suaKhachHang();
        //xoaKhachHang();
        //hienThiKhachHang();
    }

    private static void themKhachHang() {
        System.out.println("Mời nhập các thông tin của khách hàng mới: ");

        System.out.print("Tên khách hàng: ");
        String Name = Utility.getInputLine();

        System.out.print("Email: ");
        String Address = Utility.getInputLine();

        System.out.print("Điện thoại: ");
        String Phone = Utility.getInputLine();

        System.out.print("Địa chỉ: ");
        String Email = Utility.getInputLine();

        String query = "INSERT INTO customer (Name, Address, Phone, Email, UserName, Password, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled)\n" +
                "VALUES (" + Name + ", " + Address + ", " + Phone + ", " + Email + ", NULL, NULL, NULL, 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, true);";

        int countRecordAffected = Utility.executeUpdate("eBookStore", query);
        System.out.println("Số bản ghi bị ảnh hưởng: " + countRecordAffected);
    }

    private static void suaKhachHang() {
        System.out.print("Nhập IDCustomer: ");
        int IDBook = Utility.getInputInt();

        System.out.println("Mời nhập các thông tin của khách hàng cần sửa: ");

        System.out.print("Email: ");
        String Address = Utility.getInputLine();

        System.out.print("Điện thoại: ");
        String Phone = Utility.getInputLine();

        System.out.print("Địa chỉ: ");
        String Email = Utility.getInputLine();

        String query = "UPDATE Customer SET Email = '" + Email + "', Phone = '" + Phone +
                "', Address = '" + Address + "' WHERE IDCustomer = " + IDBook;

        int countRecordAffected = Utility.executeUpdate("eBookStore", query);
        System.out.println("Số bản ghi bị ảnh hưởng: " + countRecordAffected);
    }

    private static void xoaKhachHang() {
        System.out.print("Nhập IDCustomer: ");
        int IDBook = Utility.getInputInt();

        String query = "DELETE FROM Customer WHERE IDCustomer = " + IDBook;

        int countRecordAffected = Utility.executeUpdate("eBookStore", query);
        System.out.println("Số bản ghi bị ảnh hưởng: " + countRecordAffected);
    }

    private static void hienThiKhachHang() {
        String query = "SELECT * FROM Customer LIMIT 100;";
        ResultSet resultSet = Utility.executeQuery("eBookStore", query);

        System.out.println("Results: ");

        try {
            while (resultSet.next()) {
                System.out.println(
                        String.format("%-5s %-25s %-20s %-15s %-25s %-15s %-10s %-280s %-12s %-12s %-8s %-8s %-5s",
                                resultSet.getInt("IDCustomer"),
                                resultSet.getString("Name"),
                                resultSet.getString("Address"),
                                resultSet.getString("Phone"),
                                resultSet.getString("Email"),
                                resultSet.getString("UserName"),
                                resultSet.getString("Password"),
                                resultSet.getString("Description"),
                                resultSet.getString("CreatedBy"),
                                resultSet.getString("UpdatedBy"),
                                resultSet.getDate("CreatedDate"),
                                resultSet.getDate("UpdatedDate"),
                                resultSet.getBoolean("Enabled")));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    //endregion
}
