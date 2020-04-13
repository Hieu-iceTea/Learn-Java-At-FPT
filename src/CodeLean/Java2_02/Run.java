/**
 * [Java2_02] Bài tập về Array trong Java
 * https://www.codelean.vn/2019/12/java202-bai-tap-ve-array-trong-java.html
 */

package CodeLean.Java2_02;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Run {
    public static void main(String[] args) {
        while (true){
            try {
                System.out.print("\n _ _ _ _ _ MENU: _ _ _ _ _\n" +
                        "| 1 - Ex1_Temprature      |\n" +
                        "| 2 - Ex2_Calculator      |\n" +
                        "| 3 - Ex3_MovieList       |\n" +
                        "| 0 - EXIT PROGRAM.       |\n" +
                        "| => Enter your chose: ");
                int chose = getInputInt();
                System.out.println("| _ _ _ _ _ _ _ _ _ _ _ _ |\n");
                switch (chose){
                    case 1:
                        Ex1_Temprature();
                        break;
                    case 2:
                        Ex2_Calculator();
                        break;
                    case 3:
                        Ex3_MovieList();
                        break;
                    case 0:
                        exit(0);
                    default:
                        System.out.println("Invalid, please return...");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("[ERROR]" + ex);
            }
        }
    }

    /** Ex1: Temprature */
    private static void Ex1_Temprature() {
        /**
         * Viết một chương trình đơn giản, nhập một danh sách nhiệt độ của n ngày liên tiếp.
         * Trong đó: n là kích thước của mảng nhiệt độ và kiểu dữ liệu của nhiệt độ là số nguyên.
         * Số n - số ngày do người dùng nhập vào.
         */

    //Người dùng sẽ nhập vào n - tương đương với số ngày cần nhập nhiệt độ:
        Scanner input = new Scanner(System.in);
        System.out.print("Mời nhập số ngày cần nhập nhiệt độ: ");
        int n = input.nextInt();

    //Khởi tạo list và nhập các phần tử:
        System.out.println("Mời nhập lần lượt nhiệt độ của các ngày: ");
        int[] listTemprature = new int[n];
        for (int i = 0; i < n; ++i) {
            System.out.print("Ngày thứ " + (i + 1) + ": ");
            listTemprature[i] = input.nextInt();
        }

    //Hiện thị list vừa nhập:
        System.out.println("Bạn vừa nhập nhiệt độ cho " + listTemprature.length
                + " ngày: ");
        for (var item : listTemprature) {
            System.out.println(item);
        }

    //Tính và hiện thị nhiệt độ trung bình:
        int sum = 0;
        /** Lặp kiểu này là nhẹ nhất (performance tốt nhất) */
        for (var item : listTemprature) {
            sum = sum + item;
        }
        int avg = sum/listTemprature.length;
        System.out.println("Nhiệt độ trung bình: " + avg);

    //Tính và hiện thị số ngày cao hơn nhiệt độ trung bình:
        int count = 0;
        for (var item : listTemprature) {
            if (item > avg) {
                ++count;
            }
        }
        System.out.println("Có [" + count + "] ngày cao hơn nhiệt độ trung bình.");
    }

    /** Ex2: Calculator */
    private static void Ex2_Calculator() {
        /**
         * Viết một chương trình đơn giản để nhập vào một mảng số nguyên và tính ra giá trị trung bình của mảng đó
         */

        /**
         * Yêu cầu cấu trúc chương trình gồm:
         * • hàm main() điều khiển luồng chính của chương trình, khởi tạo mảng, gọi hàm initArray và hàm getAverage
         * • hàm int[] intArray(int size) thực hiện nhập giá trị cho mảng có size phần tử và trả về một mảng số nguyên
         * • hàm doube getAverage(int[] array) tính nhiệt độ trung bình của mảng array và trả về giá trị trung bình
         * là kiểu dữ liệu double.
         */

        System.out.print("Enter size: ");
        int size = getInputInt();
        System.out.println("Enter " + size + " integer values: ");
        int[] arr = initArray(size);
        System.out.println("Average : " + getAverage(arr));
    }

    private static int[] initArray(int size) {
        int[] result = new int[size];

        for (int i = 0; i < size; ++i) {
            System.out.print("Value " + (i + 1) + ": ");
            result[i] = getInputInt();
        }

        return result;
    }

    private static double getAverage(int[] arr) {
        int sum = 0;
        for (var item : arr) {
            sum += item;
        }
        return (double) sum / arr.length;
    }

    private static List<Integer> initArray_useList(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            System.out.print("Value " + (i + 1) + ": ");
            int tmp = getInputInt();
            result.add(tmp);
        }

        return result;
    }

    private static double getAverage_useList(List<Integer> integerList) {
        int sum = 0;

        Iterator<Integer> integerList_Iterator = integerList.iterator();
        while (integerList_Iterator.hasNext()) {
            sum += integerList_Iterator.next();
        }

        return sum / integerList.size();
    }

    /** Ex3: MovieList */
    private static void Ex3_MovieList() {
        /**
         * Viết chương trình cho phép người dùng nhập danh sách bộ phim yêu thích. Chương trình cho phép người dùng thực hiện các việc sau:
         * - thêm phim mới
         * - in ra danh sách các bộ phim yêu thích
         * - chỉnh sửa tên phim đã có
         * - xoá đi một bộ phim khỏi danh sách yêu thích
         * - tìm kiếm tên phim trong danh sách yêu thích
         */

        //List<String> myFavoriteFilm = new ArrayList<>();

        String filePath = "file\\myFavoriteFilm.txt";
        List<String> myFavoriteFilm = readFile(filePath);

        boolean flagContinue = true;
        boolean changed = false;
        while (flagContinue) {
            try {
                System.out.print("\n _ _ _ _ _ _ SUB-MENU: My Favorite Film _ _ _ _ _ _ \n" +
                        "| 1 - Thêm phim mới                                |\n" +
                        "| 2 - In ra danh sách các bộ phim yêu thích        |\n" +
                        "| 3 - Chỉnh sửa tên phim đã có                     |\n" +
                        "| 4 - Xoá đi một bộ phim khỏi danh sách yêu thích  |\n" +
                        "| 5 - Tìm kiếm tên phim trong danh sách yêu thích  |\n" +
                        "| 6 - Lưu file                                     |\n" +
                        "| 7 - Đọc lại file                                 |\n" +
                        "| 0 - Quay lại                                     |\n" +
                        "| => Lựa chọn của bạn: ");
                int chose = getInputInt();
                System.out.println("| _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _  _ _ _ _ _ _ |\n");
                switch (chose) {
                    case 1:
                        addNew(myFavoriteFilm);
                        changed = true;
                        break;
                    case 2:
                        System.out.println("Danh sách các bộ phim yêu thích: ");
                        show(myFavoriteFilm);
                        break;
                    case 3:
                        edit(myFavoriteFilm);
                        changed = true;
                        break;
                    case 4:
                        delete(myFavoriteFilm);
                        changed = true;
                        break;
                    case 5:
                        Search(myFavoriteFilm);
                        break;
                    case 6:
                        writerFile(myFavoriteFilm, filePath);
                        changed = false;
                        break;
                    case 7:
                        checkChanged(changed, myFavoriteFilm, filePath);
                        myFavoriteFilm = readFile(filePath);
                        System.out.println("Đọc lại file Thành Công");
                        break;
                    case 0:
                        checkChanged(changed, myFavoriteFilm, filePath);
                        flagContinue = false;
                        break;
                    default:
                        System.out.println("Invalid in SUB-MENU.");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(ex);
            }
        }
    }

    private static void addNew(List<String> myFavoriteFilm) {
        System.out.print("Nhập tên phim cần thêm: ");
        String newFilm = getInputStringLine();
        if (isConfirm("Xác nhận thêm mới phim ["+ newFilm +"] Vào danh sách hiện tại?")) {
            myFavoriteFilm.add(newFilm);
            System.out.println("Thêm mới phim ["+ myFavoriteFilm.get(myFavoriteFilm.size() - 1) +"] Thành công!");
        } else {
            System.out.println("Đã hủy thao tác.");
        }
    }

    private static void show(List<String> listFilm) {
        if (listFilm.isEmpty()) {
            System.out.println("Danh sách phim trống...");
            return;
        }
        for (int i = 0; i < listFilm.size(); ++i) {
            System.out.println((i+1) + ". " + listFilm.get(i));
        }
    }

    private static void edit(List<String> myFavoriteFilm) {
        if (myFavoriteFilm.isEmpty()) {
            System.out.println("Danh sách phim trống...");
            return;
        }

        int choseIndex = choseFilm(myFavoriteFilm, "Bạn muốn sửa tên của phim nào trong danh sách sau: ");

        System.out.println("Tên cũ: " + myFavoriteFilm.get(choseIndex));
        System.out.print("Mời nhập tên mới: ");
        String newName = getInputStringLine();

        if (isConfirm("Xác nhận lưu tên mới?")) {
            myFavoriteFilm.set((choseIndex), newName);
            System.out.println("Sửa tên Thành công!");
        } else {
            System.out.println("Đã hủy thao tác.");
        }
    }

    private static void delete(List<String> myFavoriteFilm) {
        if (myFavoriteFilm.isEmpty()) {
            System.out.println("Danh sách phim trống...");
            return;
        }

        int choseIndex = choseFilm(myFavoriteFilm, "Bạn muốn xóa phim nào trong danh sách sau: ");

        if (isConfirm("Xác nhận xóa film: " + myFavoriteFilm.get(choseIndex) + "?")) {
            myFavoriteFilm.remove(choseIndex);
            System.out.println("Xóa thành công phim");
        } else {
            System.out.println("Đã hủy thao tác.");
        }
    }

    private static void Search(List<String> myFavoriteFilm) {
        if (myFavoriteFilm.isEmpty()) {
            System.out.println("Danh sách phim trống...");
            return;
        }

        System.out.print("Nhập tên phim cần tìm kiếm: ");
        String nameOfFilm = getInputStringLine();

        //int indexSearch = myFavoriteFilm.indexOf(nameOfFilm);

        List<String> result = new ArrayList<>();
        for (var item : myFavoriteFilm) {
            if (item.toLowerCase().contains(nameOfFilm.toLowerCase())) {
                result.add(item);
            }
        }

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy tên phim của bạn! ");
            return;
        }

        System.out.println("Kết quả tìm kiếm: ");
        show(result);
    }

    private static int choseFilm(List<String> myFavoriteFilm, String message) {
        System.out.println(message);
        show(myFavoriteFilm);

        int choseIndex = -1;
        while (true) {
            System.out.print("Bạn chọn (1-" + myFavoriteFilm.size() + ") : ");
            choseIndex = getInputInt();
            if (choseIndex < 1 || choseIndex > myFavoriteFilm.size()) {
                System.out.println("[ERROR] Lựa chọn sai, mời chọn lại...");
            } else {
                break;
            }
        }

        return choseIndex - 1;
    }

    private static List<String> readFile(String path){
        List<String> myFavoriteFilm = new ArrayList<>();

        try {
            Scanner inputFile = new Scanner(new File(path));
            while (inputFile.hasNextLine()) {
                myFavoriteFilm.add(inputFile.nextLine());
            }
            return myFavoriteFilm;
        } catch (Exception ex){
            System.out.println("Có lỗi xảy ra trong quá trình đọc file.");
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    public static void writerFile(List<String> stringList, String path) {
        try {
            if (isConfirm("Xác nhận lưu file?")) {
                FileWriter myWriter = new FileWriter(path);
                myWriter.write(""); //Xóa hết file cũ

                for (var item : stringList) {
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

    private static void checkChanged(boolean changed, List<String> myFavoriteFilm, String filePath) {
        if (changed) {
            if (isConfirm("Dữ liệu đã bị thay đổi nhưng chưa được lưu vào file, " +
                    "dữ liệu sẽ mất nếu bạn quay lại hoạc tải lại trang này.\n" +
                    "Bạn có muốn lưu không?")) {
                writerFile(myFavoriteFilm, filePath);
            } else {
                System.out.println("Dữ liệu chưa được lưu!");
            }
        }
    }

    /** Common Method */
    private static boolean isConfirm(String message) {
        System.out.print(message + " [Y/N]: ");
        while (true) {
            String confirm = getInputStringLine();
            switch (confirm) {
                case "Y": case "y":
                    return true;
                case "N": case "n":
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
}
