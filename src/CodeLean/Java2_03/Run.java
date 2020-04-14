/**
 * [Java2_03] Case Study: Contact List
 * https://www.codelean.vn/2020/01/java203-case-study-contact-list.html
 */

package CodeLean.Java2_03;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Run {
    public static void main(String[] args) {
        ContactList listContact = new ContactList();

        //String filePath = "file\\ContactList.txt";
        String filePath = "file\\ContactList_FPT_APTECH_T1909M.txt";
        //String filePath = "file\\ContactList_Test_Speed.txt";

        listContact = readFile(filePath);

        while (true) {
            try {
                System.out.print(" _ _ _ _ _ _ _ _ _ MENU _ _ _ _ _ _ _ _ _ \n" +
                        "| 1 - Hiện thị danh sách danh bạ         |\n" +
                        "| 2 - Thêm mới danh bạ                   |\n" +
                        "| 3 - Sửa danh bạ đã có trong danh sách  |\n" +
                        "| 4 - Xóa danh bạ đã có trong danh sách  |\n" +
                        "| 5 - Tìm kiếm danh bạ                   |\n" +
                        "| 6 - Hiện thị MENU                      |\n" +
                        "| 7 - Đọc lại file                       |\n" +
                        "| 8 - Lưu dữ liệu vào file               |\n" +
                        "| 0 - THOÁT CHƯƠNG TRÌNH.                |\n" +
                        " => Lựa chọn của bạn (0-6): ");
                int chose = getInputInt();
                System.out.println(" - - - - - - - - - - - - - - - - - - - - \n");
                switch (chose) {
                    case 1:
                        printList(listContact);
                        pause_PressEnterToContinue();
                        break;
                    case 2:
                        addContact(listContact);
                        pause_PressEnterToContinue();
                        break;
                    case 3:
                        updateContact(listContact);
                        pause_PressEnterToContinue();
                        break;
                    case 4:
                        removeContact(listContact);
                        pause_PressEnterToContinue();
                        break;
                    case 5:
                        searchContact(listContact);
                        pause_PressEnterToContinue();
                        break;
                    case 6:
                        continue; //Nothing
                        //break;
                    case 7:
                        ContactList listContact_readFile = readFile(filePath);
                        if (!listContact.equals(listContact_readFile)) {
                            if (isConfirm("Dữ liệu đã bị thay đổi nhưng chưa được lưu. " +
                                    "Tải lại file sẽ làm mất toàn bộ dữ liệu hiện tại.\n" +
                                    "Xác nhận tải lại file?")) {
                                listContact = listContact_readFile;
                            }
                        } else {
                            listContact = listContact_readFile;
                            System.out.println("Tải lại file thành công.");
                        }
                        pause_PressEnterToContinue();
                        break;
                    case 8:
                        writerFile(listContact, filePath);
                        pause_PressEnterToContinue();
                        break;
                    case 0:
                        String message = "";
                        if (!listContact.equals(readFile(filePath))) {
                            message = "Dữ liệu đã bị thay đổi nhưng chưa được lưu. Xác nhận thoát chương trình?";
                        } else {
                            message = "Xác nhận thoát chương trình?";
                        }
                        if (isConfirm(message)) {
                            System.exit(0);
                        }
                        break;
                    default:
                        System.out.println("[ERROR] Nhập liệu không hợp lệ, Hãy nhập lại...");
                        pause_PressEnterToContinue();
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("[ERROR] " + ex);
            }
        }
    }

    private static void printList(ContactList listContact) {
        System.out.println(" - Danh sách danh bạ - ");
        listContact.printList();
        System.out.println("- - - - -");
    }

    private static void addContact(ContactList listContact) {
        System.out.println(" - Thêm mới danh bạ - ");
        System.out.println("Mời nhập các thông tin cho danh bạ: ");
        Contact newContact = getInputContact();
        if (isConfirm("Xác nhận lưu [" + newContact + "] vào danh bạ?")) {
            listContact.addContact(newContact);
        }
    }

    private static void updateContact(ContactList listContact) {
        System.out.println(" - Cập nhật danh bạ - ");
        int indexChose = getChoseContactInList(listContact,"Bạn muốn sửa danh bạ nào trong danh sách trên?");
        System.out.println("Thông tin cũ [" + listContact.getContactByIndex(indexChose) + "]");
        System.out.println("Nhập thông tin mới cho danh bạ: ");
        Contact newContact = getInputContact();

        if (!listContact.getContactByIndex(indexChose).equals(newContact)) {
            if (isConfirm("Xác nhận sửa thông tin danh bạ thành [" + newContact + "]")) {
                listContact.updateContact(listContact.getContactByIndex(indexChose), newContact);
            }
        } else {
            System.out.println("Thông tin mới bạn vừa nhập giống hệt thông tin cũ. Thao tác sẽ bị hủy.");
        }
    }

    private static void removeContact(ContactList listContact) {
        System.out.println(" - Xóa danh bạ - ");
        int indexChose = getChoseContactInList(listContact,"Bạn muốn xóa danh bạ nào trong danh sách trên?");
        if (isConfirm("Xác nhận xóa danh bạ [" + listContact.getContactByIndex(indexChose) + "] khỏi danh sách hiện tại?")) {
            listContact.removeContact(listContact.getContactByIndex(indexChose));
        }
    }

    private static void searchContact(ContactList listContact) {
        System.out.println(" - Tìm kiếm danh bạ - ");
        System.out.print("Nhập tên: ");
        String name = getInputStringLine();
        listContact.searchContact(name);
    }

    /** Common Method */
    private static Contact getInputContact() {
        System.out.print("Tên: ");
        String name = getInputStringLine();
        System.out.print("Số điện thoại: ");
        String phone = getInputStringLine();
        return new Contact(name, phone);
    }

    private static int getChoseContactInList(ContactList contactList, String message) {
        contactList.printList();
        System.out.println(message);

        int choseIndex = -1;
        while (true) {
            System.out.print("Bạn chọn (1-" + contactList.getSize() + ") : ");
            choseIndex = getInputInt();
            if (choseIndex < 1 || choseIndex > contactList.getSize()) {
                System.out.println("[ERROR] Lựa chọn sai, mời chọn lại...");
            } else {
                return choseIndex - 1;
            }
        }
    }

    private static boolean isConfirm(String message) {
        System.out.print(message + " [Y/N]: ");
        while (true) {
            String confirm = getInputStringLine();
            switch (confirm) {
                case "Y": case "y":
                    System.out.println("Thành công!");
                    return true;
                case "N": case "n":
                    System.out.println("Hủy thao tác!");
                    return false;
                default:
                    System.out.println("[ERROR] Lựa chọn không hợp lệ, mời chọn lại...");
                    break;
            }
        }
    }

    private static int getInputInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static String getInputStringLine() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void pause_PressEnterToContinue() {
        System.out.println("\n\tNhấn phím [Enter] để tiếp tục...");
        try{
            System.in.read();
            //getInputStringLine();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("[ERROR] " + e);
        }
    }

    /** Exten Method */
    private static ContactList readFile(String path){
        System.out.println("\nĐang đọc dữ liệu từ file, quá trình này có thể mất vài ngày...\nLoading...\n");

        ContactList listContact = new ContactList();
        try {
            Scanner inputFile = new Scanner(new File(path));
            while (inputFile.hasNextLine()) {
                String line = inputFile.nextLine();
                String[] element = line.split(": ");
                if (element.length == 2 && (!element[0].isBlank() || !element[1].isBlank())) {
                    if (element[0].isBlank()) {
                        element[0] = "null";
                    }
                    if (element[1].isBlank()) {
                        element[1] = "null";
                    }
                    Contact contact = new Contact(element[0], element[1]);
                    listContact.addContact(contact);
                } else if (element.length == 1) {
                    listContact.addContact(new Contact(element[0], "ERROR"));
                } else  {
                    listContact.addContact(new Contact("ERROR", "ERROR"));
                }
            }
            inputFile.close();
            return listContact;
        } catch (Exception ex){
            System.out.println("Có lỗi xảy ra trong quá trình đọc file.");
            ex.printStackTrace();
        }

        return new ContactList();
    }

    private static void writerFile(ContactList listContact, String path) {
        try {
            if (isConfirm("Xác nhận lưu file?")) {
                FileWriter myWriter = new FileWriter(path);
                myWriter.write(""); //Xóa hết file cũ

                for (var item : listContact.getListContact()) {
                    myWriter.append(item + System.getProperty("line.separator"));
                }

                myWriter.close();
                System.out.println("Lưu file Thành công!");
            } else {
                System.out.println("Hủy lưu file");
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra trong quá trình ghi file.");
            e.printStackTrace();
        }
    }
}