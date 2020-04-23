package CodeLean.Java2_06.GiftShop.GiftView;

import CodeLean.Java2_06.GiftShop.GiftController.GiftController;
import CodeLean.Java2_06.GiftShop.GiftModel.Gift;
import MyUtilities.Utility;

import java.util.List;

public class GiftShop {
    public static void main(String[] args) {
        try {
            while (true) {
                System.out.print("\n _ _ _ _ _ _ _ _ Menu GiftShop _ _ _ _ _ _ _ _\n" +
                        "| 1. Xem danh sách quà tặng (Xem sách)        |\n" +
                        "| 2. Thêm quà tặng (Thêm sách)                |\n" +
                        "| 3. Xoá quà tặng (Xoá sách)                  |\n" +
                        "| 0. THOÁT                                    |\n" +
                        "  => Bạn chọn: ");
                int chose = Utility.getInputInt();
                System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");

                switch (chose) {
                    case 1:
                        viewAllBooks();
                        Utility.pause_PressEnterToContinue();
                        break;
                    case 2:
                        addBook();
                        Utility.pause_PressEnterToContinue();
                        break;
                    case 3:
                        deleteBook();
                        Utility.pause_PressEnterToContinue();
                        break;
                    case 0:
                        if (Utility.isConfirm("Xác nhận thoát chương trình?")) {
                            System.exit(1);
                        }
                    default:
                        break;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * <b>1. chọn xem quà tặng </b> <br>
     * Khi chọn 1 thì hiển thị toàn bộ sách có trong thư viện.
     */
    private static void viewAllBooks() {
        GiftController giftController = new GiftController();
        List<Gift> lstGift = giftController.selectAllColumn();

        System.out.println("");
        for (var item : lstGift) {
            System.out.println(item);
        }
    }

    private static void addBook() {
        Gift gift = new Gift();

        //IDAuthor, IDCategory, IDPublishCompany, Name, Price, Qty, DatePublish, Description
        System.out.println("Mời nhập các thông tin cho cuốn sách: ");

        System.out.print("Tên sách: ");
        String Name = Utility.getInputLine();
        gift.setName(Name);

        System.out.print("ID Tác giả (Nhập 0 để hiện danh sách tác giả): ");
        int IDAuthor = Utility.getInputInt();
        if (IDAuthor == 0) {
            GiftController giftController = new GiftController();
            IDAuthor = giftController.choseIDFromTable("Author");
        }
        gift.setIDAuthor(IDAuthor);

        System.out.print("ID Thể loại (Nhập 0 để hiện danh sách thể loại): ");
        int IDCategory = Utility.getInputInt();
        if (IDCategory == 0) {
            GiftController giftController = new GiftController();
            IDCategory = giftController.choseIDFromTable("Category");
        }
        gift.setIDCategory(IDCategory);

        System.out.print("ID Nhà phát hành (Nhập 0 để hiện danh sách nhà phát hành): ");
        int IDPublishCompany = Utility.getInputInt();
        if (IDPublishCompany == 0) {
            GiftController giftController = new GiftController();
            IDPublishCompany = giftController.choseIDFromTable("PublishCompany");
        }
        gift.setIDPublishCompany(IDPublishCompany);

        System.out.print("Giá bán: ");
        Double Price = Utility.getInputDouble();
        gift.setPrice(Price);

        System.out.print("Số lượng trong kho hiện tại: ");
        int Qty = Utility.getInputInt();
        gift.setQty(Qty);

        System.out.print("Ngày phát hành (yyyy-mm-dd): ");
        String strDatePublish = Utility.getInputLine();
        gift.setDatePublish(Utility.stringToDate("yyyy-mm-dd", strDatePublish));

        System.out.print("Mô tả về sách: ");
        String Description = Utility.getInputLine();
        gift.setDescription(Description);


        if (Utility.isConfirm("Xác nhận thêm 1 bản ghi? ")) {
            GiftController giftController = new GiftController();
            giftController.insertItem(gift);
            System.out.println("Thêm thành công");
        }
    }

    private static void deleteBook() {
        System.out.print("Nhập ID sách muốn xoá (Nhập 0 để hiện danh sách): ");
        int IDBook = Utility.getInputInt();
        if (IDBook == 0) {
            GiftController giftController = new GiftController();
            IDBook = giftController.choseIDFromTable("Book");
        }

        if (Utility.isConfirm("Xác nhận xoá 1 bản ghi? ")) {
            GiftController giftController = new GiftController();
            giftController.deleteItemByID(IDBook);
        }
    }
}
