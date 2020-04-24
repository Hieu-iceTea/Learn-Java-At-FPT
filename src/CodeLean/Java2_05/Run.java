package CodeLean.Java2_05;

import MyUtilities.Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * [Java2_05] eBookStore Online: design database & select
 * https://www.codelean.vn/2020/03/java205-ebookstore-online-design.html
 */
public class Run {
    public static void main(String[] args) {
        while (true) {
            System.out.print("\n _ _ _ MENU _ _ _ \n" +
                    "1. Xem sách \n" +
                    "2. Xem Order\n" +
                    "0. THOÁT. \n" +
                    "  => Bạn chọn: ");
            int chose = Utility.getInputInt();
            System.out.println(" _ _ _ _ _ _ _ _ ");

            switch (chose) {
                case 1:
                    xemSach();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 2:
                    xemDonHang();
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

    //region Xem Sách
    /**
     * <b>2. Xây dựng tính năng Xem Sách</b> <br>
     *
     *   ✓ Để mua sách, thì trước tiên người dùng cần xem được sách.
     *   Bạn hãy phát triển phần nghiệp vụ để người dùng có thể xem sách theo các tiêu chí sau: <br>
     *
     * • Xem toàn bộ 10 cuốn sách mới nhất <br>
     * • Xem 100 cuốn sách bán chạy nhất <br>
     * • Tìm sách theo thể loại (người dùng nhập thể loại, sau đó sẽ hiển thị sách theo thể loại đó) <br>
     * • Tìm sách theo tên tác giả (người dùng nhập tên tác giả, sau đó sẽ hiển thị toàn bộ sách của tác giả đó) <br>
     * • Xem chi tiết về cuốn sách (người dùng nhập id của sách, hiển thị chi tiết toàn bộ thông tin về sách). <br>
     */
    private static void xemSach() {
        while (true) {
            System.out.print("\n _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ Xem Sach _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ \n" +
                    "1. Xem toàn bộ 10 cuốn sách mới nhất \n" +
                    "2. Xem 100 cuốn sách bán chạy nhất\n" +
                    "3. Tìm sách theo thể loại (người dùng nhập thể loại, sau đó sẽ hiển thị sách theo thể loại đó)\n" +
                    "4. Tìm sách theo tên tác giả (người dùng nhập tên tác giả, sau đó sẽ hiển thị toàn bộ sách của tác giả đó)\n" +
                    "5. Xem chi tiết về cuốn sách (người dùng nhập id của sách, hiển thị chi tiết toàn bộ thông tin về sách). \n" +
                    "0. THOÁT. \n" +
                    "  => Bạn chọn: ");
            int chose = Utility.getInputInt();
            System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");

            switch (chose) {
                case 1:
                    xem10SachMoiNhat();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 2:
                    xem100SachBanChayNhat();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 3:
                    timSachTheoTheLoai();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 4:
                    timSachTheoTacGia();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 5:
                    xemChiTietSach();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 0:
                    if (Utility.isConfirm("Xác nhận thoát?")) {
                        return;
                    }
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    Utility.pause_PressEnterToContinue();
                    break;
            }
        }
    }

    private static void xem10SachMoiNhat() {
        String query = "SELECT *\n" +
                "FROM Book\n" +
                "WHERE Enabled = TRUE\n" +
                "ORDER BY DatePublish DESC\n" +
                "LIMIT 10;";
        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListBook_FromResultSet(resultSet);
    }

    private static void xem100SachBanChayNhat() {
        String query = "SELECT Book.*, SUM(OrderDetail.Qty) AS coutBook\n" +
                "FROM `Order`\n" +
                "    JOIN Orderdetail ON `Order`.IDOrder = OrderDetail.IDOrder\n" +
                "    JOIN Book ON OrderDetail.IDBook = Book.IDBook\n" +
                "WHERE `Order`.CreatedDate > DATE_ADD(CURRENT_DATE, INTERVAL -30 DAY)\n" +
                "    AND `Order`.Status IN (1, 2, 3, 4, 5)\n" +
                "    AND `Order`.Enabled = TRUE\n" +
                "    AND Orderdetail.Enabled = TRUE\n" +
                "    AND Book.Enabled = TRUE\n" +
                "GROUP BY Book.IDBook\n" +
                "ORDER BY coutBook DESC\n" +
                "LIMIT 100;";
        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListBook_FromResultSet(resultSet);
    }

    private static void timSachTheoTheLoai() {
        System.out.print("Enter category: ");
        String strCategory = Utility.getInputLine();

        String query = "SELECT Category.Name AS CategoryNameNe, Book.*\n" +
                "FROM Book\n" +
                "    JOIN Category on Book.IDCategory = Category.IDCategory\n" +
                "WHERE Category.Name LIKE '%" + strCategory + "%'\n" +
                "    AND Book.Enabled = TRUE\n" +
                "    AND Category.Enabled = TRUE\n" +
                "ORDER BY Category.Name;";
        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        System.out.println("Search results: ");
        printListBook_FromResultSet(resultSet);
    }

    private static void timSachTheoTacGia() {
        System.out.print("Enter name of Author: ");
        String strAuthorName = Utility.getInputLine();

        String query = "SELECT Book.*\n" +
                "FROM Book\n" +
                "    JOIN Author on Book.IDAuthor = Author.IDAuthor\n" +
                "WHERE Author.Name LIKE '%" + strAuthorName + "%'\n" +
                "    AND Book.Enabled = TRUE\n" +
                "    AND Author.Enabled = TRUE;";
        ResultSet resultSet = Utility.executeQuery("eBookStore", query);

        System.out.println("Search results: ");
        printListBook_FromResultSet(resultSet);
    }

    private static void xemChiTietSach() {
        System.out.print("Enter ID of book: ");
        int IDBook = Utility.getInputInt();

        String query = "SELECT Author.Name, Category.Name, PublishCompany.Name, Book.*\n" +
                "FROM Book\n" +
                "    JOIN Author on book.IDAuthor = Author.IDAuthor\n" +
                "    JOIN Category on book.IDCategory = Category.IDCategory\n" +
                "    JOIN PublishCompany on book.IDPublishCompany = PublishCompany.IDPublishCompany\n" +
                "WHERE Book.IDBook = 1\n" +
                "    AND Book.Enabled = TRUE;";
        ResultSet resultSet = Utility.executeQuery("eBookStore", query);

        System.out.println("Results: ");
        printListBook_FromResultSet(resultSet);
    }
    //endregion

    //region Xem Đơn Hàng
    /**
     * <b>3. Xây dựng tính năng Xem Đơn Hàng</b> <br>
     *
     * ✓ Sau khi xem sách xong thì người ta sẽ mua sách. Phần mua sách chúng ta sẽ thực hiện ở Step2.
     * Trong step1, giả dụ như trong cơ sở dữ liệu của bạn đã sẵn có các đơn hàng,
     * bây giờ bạn cần phá triển tính năng sau để xem thông tin về đơn hàng: <br>
     *
     * • Hiển thị 30 đơn hàng mới tiếp nhận (set theo status = 1) <br>
     * • Hiển thị đơn hàng theo mã khách hàng  <br>
     * • Hiển thị trạng thái đơn hàng theo mã đơn hàng <br>
     * • Hiển thị thông tin chi tiết của một đơn hàng theo mã đơn được nhập vào <br>
     * • Hiển thị những đơn hàng đang chờ xử lý (set theo status = 2)  <br>
     * • Hiển thị những đơn hàng đã đóng gói (set theo status = 3) <br>
     * • Hiển thị những đơn hàng đã gửi vận chuyển (set theo status = 4) <br>
     * • Hiển thị những đơn hàng đã giao hàng thành công (set theo status = 5) <br>
     * • Hiển thị những đơn hàng bị khách hàng huỷ (set theo status = 0).
     */
    private static void xemDonHang() {
        while (true) {
            System.out.print("\n _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ Xem Don Hang _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ \n" +
                    "1. Hiển thị 30 đơn hàng mới tiếp nhận (set theo status = 1)\n" +
                    "2. Hiển thị đơn hàng theo mã khách hàng \n" +
                    "3. Hiển thị trạng thái đơn hàng theo mã đơn hàng \n" +
                    "4. Hiển thị thông tin chi tiết của một đơn hàng theo mã đơn được nhập vào \n" +
                    "5. Hiển thị những đơn hàng đang chờ xử lý (set theo status = 2) \n" +
                    "6. Hiển thị những đơn hàng đã đóng gói (set theo status = 3)\n" +
                    "7. Hiển thị những đơn hàng đã gửi vận chuyển (set theo status = 4)\n" +
                    "8. Hiển thị những đơn hàng đã giao hàng thành công (set theo status = 5) \n" +
                    "9. Hiển thị những đơn hàng bị khách hàng huỷ (set theo status = 0). \n" +
                    "0. THOÁT. \n" +
                    "  => Bạn chọn: ");
            int chose = Utility.getInputInt();
            System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");

            switch (chose) {
                case 1:
                    xem30DonHangMoi();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 2:
                    xemDonHangTheoIDKhachHang();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 3:
                    xemTrangThaiDonHangTheoID();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 4:
                    xemChiTietDonHangTheoID();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 5:
                    xemDonHangDangChoXuLy();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 6:
                    xemDonHangDaDongGoi();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 7:
                    xemDonHangDaGuiVanChuyen();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 8:
                    xemDonHangDaGiaoHangThanhCong();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 9:
                    xemDonHangBiKhachHangHuy();
                    Utility.pause_PressEnterToContinue();
                    break;
                case 0:
                    if (Utility.isConfirm("Xác nhận thoát?")) {
                        return;
                    }
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    Utility.pause_PressEnterToContinue();
                    break;
            }
        }
    }

    private static void xem30DonHangMoi() {
        String query = "SELECT *\n" +
                "FROM `Order`\n" +
                "WHERE Status = 1\n" +
                "    AND Enabled = TRUE\n" +
                "ORDER BY CreatedDate DESC\n" +
                "LIMIT 30;";

        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListOrder_FromResultSet(resultSet);
    }

    private static void xemDonHangTheoIDKhachHang() {
        System.out.print("Enter IDCustomer: ");
        int IDCustomer = Utility.getInputInt();

        String query = "SELECT *\n" +
                "FROM `Order`\n" +
                "    JOIN OrderDetail on `order`.IDOrder = OrderDetail.IDOrder\n" +
                "    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer\n" +
                "WHERE Customer.IDCustomer = " + IDCustomer + "\n" +
                "    AND `Order`.Enabled = TRUE\n" +
                "    AND OrderDetail.Enabled = TRUE\n" +
                "    AND Customer.Enabled = TRUE\n" +
                "ORDER BY `Order`.CreatedDate DESC, `Order`.IDOrder DESC ;";

        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListOrder_FromResultSet(resultSet);
    }

    private static void xemTrangThaiDonHangTheoID() {
        System.out.print("Enter IDOrder: ");
        int IDOrder = Utility.getInputInt();

        String query = "SELECT\n" +
                "CASE Status\n" +
                "    WHEN 1 THEN 'Mới tiếp nhận'\n" +
                "    WHEN 2 THEN 'Đang chờ xử lý'\n" +
                "    WHEN 3 THEN 'Đã đóng gói'\n" +
                "    WHEN 4 THEN 'Đã gửi vận chuyển'\n" +
                "    WHEN 5 THEN 'Giao hàng thành công'\n" +
                "    WHEN 0 THEN 'Khách hàng hủy'\n" +
                "    ELSE '[] Không hợp lệ'\n" +
                "END StatusString,\n" +
                "`Order`.*\n" +
                "FROM `Order`\n" +
                "WHERE IDOrder = 1\n" +
                "    AND `Order`.Enabled = TRUE;";

        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListOrder_FromResultSet(resultSet);
    }

    private static void xemChiTietDonHangTheoID() {
        System.out.print("Enter IDOrder: ");
        int IDOrder = Utility.getInputInt();

        String query = "SELECT *\n" +
                "FROM `Order`\n" +
                "    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder\n" +
                "    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer\n" +
                "WHERE `Order`.IDOrder = " + IDOrder + "\n" +
                "    AND `Order`.Enabled = TRUE\n" +
                "    AND OrderDetail.Enabled = TRUE\n" +
                "    AND Customer.Enabled = TRUE;";

        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListOrderDetail_FromResultSet(resultSet);
    }

    private static void xemDonHangDangChoXuLy() {
        String query = "SELECT *\n" +
                "FROM `Order`\n" +
                "    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder\n" +
                "    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer\n" +
                "WHERE `Order`.Status = 2\n" +
                "    AND `Order`.Enabled = TRUE\n" +
                "    AND OrderDetail.Enabled = TRUE\n" +
                "    AND Customer.Enabled = TRUE;";

        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListOrder_FromResultSet(resultSet);
    }

    private static void xemDonHangDaDongGoi() {
        String query = "SELECT *\n" +
                "FROM `Order`\n" +
                "    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder\n" +
                "    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer\n" +
                "WHERE `Order`.Status = 3\n" +
                "    AND `Order`.Enabled = TRUE\n" +
                "    AND OrderDetail.Enabled = TRUE\n" +
                "    AND Customer.Enabled = TRUE;";

        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListOrder_FromResultSet(resultSet);
    }

    private static void xemDonHangDaGuiVanChuyen() {
        String query = "SELECT *\n" +
                "FROM `Order`\n" +
                "    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder\n" +
                "    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer\n" +
                "WHERE `Order`.Status = 4\n" +
                "    AND `Order`.Enabled = TRUE\n" +
                "    AND OrderDetail.Enabled = TRUE\n" +
                "    AND Customer.Enabled = TRUE;";

        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListOrder_FromResultSet(resultSet);
    }

    private static void xemDonHangDaGiaoHangThanhCong() {
        String query = "SELECT *\n" +
                "FROM `Order`\n" +
                "    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder\n" +
                "    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer\n" +
                "WHERE `Order`.Status = 5\n" +
                "    AND `Order`.Enabled = TRUE\n" +
                "    AND OrderDetail.Enabled = TRUE\n" +
                "    AND Customer.Enabled = TRUE;";

        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListOrder_FromResultSet(resultSet);
    }

    private static void xemDonHangBiKhachHangHuy() {
        String query = "SELECT *\n" +
                "FROM `Order`\n" +
                "    JOIN OrderDetail on `Order`.IDOrder = OrderDetail.IDOrder\n" +
                "    JOIN Customer on `order`.IDCustomer = Customer.IDCustomer\n" +
                "WHERE `Order`.Status = 0\n" +
                "    AND `Order`.Enabled = TRUE\n" +
                "    AND OrderDetail.Enabled = TRUE\n" +
                "    AND Customer.Enabled = TRUE;";

        ResultSet resultSet = Utility.executeQuery("eBookStore", query);
        printListOrder_FromResultSet(resultSet);
    }
    //endregion

    //region Common Method
    private static void printListBook_FromResultSet(ResultSet resultSet) {
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

    private static void printListOrder_FromResultSet(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                System.out.println(
                        String.format("%-5s %-5s %-5s %-5s %-280s %-12s %-12s %-8s %-8s %-5s",
                                resultSet.getInt("IDOrder"),
                                resultSet.getInt("IDCustomer"),
                                resultSet.getInt("Status"),
                                resultSet.getDouble("TotalPrice"),
                                resultSet.getString("Description"),
                                resultSet.getString("CreatedBy"),
                                resultSet.getString("UpdatedBy"),
                                resultSet.getString("CreatedDate"),
                                resultSet.getString("UpdatedDate"),
                                resultSet.getBoolean("Enabled")
                        )
                );
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private static void printListOrderDetail_FromResultSet(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                System.out.println(
                        String.format("%-5s %-5s %-5s %-5s %-5s %-280s %-12s %-12s %-8s %-8s %-5s",
                                resultSet.getInt("IDOrderDetail"),
                                resultSet.getInt("IDOrder"),
                                resultSet.getInt("IDBook"),
                                resultSet.getDouble("Price"),
                                resultSet.getInt("Qty"),
                                resultSet.getString("Description"),
                                resultSet.getString("CreatedBy"),
                                resultSet.getString("UpdatedBy"),
                                resultSet.getString("CreatedDate"),
                                resultSet.getString("UpdatedDate"),
                                resultSet.getBoolean("Enabled")
                        )
                );
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    //endregion
}
