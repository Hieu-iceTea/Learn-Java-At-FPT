package CodeLean.Java2_06.GiftShop.GiftController;

import CodeLean.Java2_06.GiftShop.GiftModel.Gift;
import MyUtilities.Utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class GiftController.java sẽ chứa các phương thức để xử lý thêm xoá và truy vấn các đối tượng Book
 * vào trong cơ sở dữ liệu. SELECT, INSERT, DELETE.
 */
public class GiftController {

    /**
     * <b>Lấy từ DB tất cả cột trong bảng Book</b> <br>
     *
     * @return Gift
     */
    public List<Gift> selectAllColumn() {
        try {
            ResultSet resultSet = Utility.executeQuery("eBookStore", "SELECT * FROM Book;");
            List<Gift> lstGift = new ArrayList<>();
            while (resultSet.next()) {
                Gift gift = new Gift();
                gift.setIDBook(resultSet.getInt("IDBook"));
                gift.setIDAuthor(resultSet.getInt("IDAuthor"));
                gift.setIDCategory(resultSet.getInt("IDCategory"));
                gift.setIDPublishCompany(resultSet.getInt("IDPublishCompany"));
                gift.setName(resultSet.getString("Name"));
                gift.setPrice(resultSet.getDouble("Price"));
                gift.setQty(resultSet.getInt("Qty"));
                gift.setDatePublish(resultSet.getDate("DatePublish"));
                gift.setDescription(resultSet.getString("Description"));
                gift.setCreatedBy(resultSet.getString("CreatedBy"));
                gift.setUpdatedBy(resultSet.getString("UpdatedBy"));
                gift.setCreatedDate(resultSet.getDate("CreatedDate"));
                gift.setUpdatedDate(resultSet.getDate("UpdatedDate"));
                gift.setEnabled(resultSet.getBoolean("Enabled"));
                lstGift.add(gift);
            }
            return lstGift;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * <b>Nhập 1 item vào DB</b>  <br>
     *
     * @param item Gift
     */
    public void insertItem(Gift item) {
        String query = "INSERT INTO Book (IDAuthor, IDCategory, IDPublishCompany, Name, Price, Qty, DatePublish, Description, CreatedBy, UpdatedBy, CreatedDate, UpdatedDate, Enabled) " +
                "VALUES (" + item.getIDAuthor() + ", " + item.getIDCategory() + ", " + item.getIDPublishCompany() + ", '" + item.getName() + "', " + item.getPrice() + ", " + item.getQty() + ", '" + Utility.dateToString("yyyy-mm-dd", item.getDatePublish()) + "', '" + item.getDescription() + "', 'Hieu-iceTea', NULL, CURRENT_TIME, NULL, TRUE);";
        System.out.println("Câu query của bạn là: \n" +query);

        int recordCount = Utility.executeUpdate("eBookStore", query);
        if (recordCount > 0) {
            System.out.println("Thành công! Số bản ghi bị ảnh hưởng: " + recordCount);
        } else {
            System.out.println("Lỗi.  Số bản ghi bị ảnh hưởng: " + recordCount);
        }
    }

    /**
     * <b>Xoá 1 item theo ID</b> <br>
     * @param id
     */
    public void deleteItemByID(int id) {
        String query = "DELETE FROM Book WHERE IDBook = " + id;
        System.out.println("Câu query của bạn là: \n" +query);

        int recordCount = Utility.executeUpdate("eBookStore", query);
        if (recordCount > 0) {
            System.out.println("Thành công! Số bản ghi bị ảnh hưởng: " + recordCount);
        } else {
            System.out.println("Lỗi.  Số bản ghi bị ảnh hưởng: " + recordCount);
        }
    }

    /**
     * <b>Hiện thị ID và Name của bảng, hỏi người dùng chọn ID nào trong bảng ấy và trả về ID đã chọn</b> <br>
     * @param tableName
     * @return
     */
    public int choseIDFromTable(String tableName) {
        try {
            int ID;
            ResultSet resultSet = Utility.executeQuery("eBookStore",
                    "SELECT ID" + tableName + ", Name FROM " + tableName + " WHERE Enabled = TRUE");
            System.out.println("ID\t\tName");
            List<Integer> lstIDAuthor = new ArrayList<>();
            int recordCount = 0;
            while (resultSet.next()) {
                lstIDAuthor.add(resultSet.getInt("ID" + tableName));
                String outPut = String.format("%-5s %-5s", resultSet.getInt("ID" + tableName), resultSet.getString("Name"));
                System.out.println(outPut);
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
}
