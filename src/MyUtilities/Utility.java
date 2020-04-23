package MyUtilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Tiện ích mở rộng cóp nhặt được của Hiếu_iceTea
 *
 * @author Hieu.iceTea
 *
 */
public class Utility {

    //region String Methods
    public static String cleanTextContent(String text){
        /**
         * Java remove non-printable non-ascii characters using regex
         * https://howtodoinjava.com/regex/java-clean-ascii-text-non-printable-chars/
         */

        // strips off all non-ASCII characters
        text = text.replaceAll("[^\\x00-\\x7F]", "");

        // erases all the ASCII control characters
        text = text.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");

        // removes non-printable characters from Unicode
        text = text.replaceAll("\\p{C}", "");

        return text.trim();
    }

    public static String readFileIntoString(File file){
        //File file = new File("c:/temp/data.txt");

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI())))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            System.out.println("Error reading " + file.getAbsolutePath());
        }
        return contentBuilder.toString();
    }

    /**
     * Lop tien ich xu ly ky tu tieng Viet
     *
     * @author quyetdv
     *
     * https://quyetdo289.wordpress.com/2015/05/17/loai-bo-dau-tieng-viet-trong-java/
     */

    // Mang cac ky tu goc co dau
    public static final char[] SOURCE_CHARACTERS = { 'À', 'Á', 'Â', 'Ã', 'È', 'É',
            'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ', 'Ù', 'Ú', 'Ý', 'à', 'á', 'â',
            'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý',
            'Ă', 'ă', 'Đ', 'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ',
            'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ', 'ẫ', 'Ậ', 'ậ',
            'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ',
            'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế', 'Ề', 'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ',
            'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ',
            'ổ', 'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ',
            'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ', 'Ừ', 'ừ', 'Ử', 'ử', 'Ữ',
            'ữ', 'Ự', 'ự', };

    // Mang cac ky tu thay the khong dau
    private static final char[] DESTINATION_CHARACTERS = { 'A', 'A', 'A', 'A', 'E',
            'E', 'E', 'I', 'I', 'O', 'O', 'O', 'O', 'U', 'U', 'Y', 'a', 'a',
            'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u',
            'y', 'A', 'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u',
            'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
            'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e',
            'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E',
            'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
            'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
            'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u',
            'U', 'u', 'U', 'u', };

    /**
     * Bỏ dấu 1 ký tự
     *
     * @param ch
     * @return
     */
    public static char removeAccent(char ch) {
        int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
        if (index >= 0) {
            ch = DESTINATION_CHARACTERS[index];
        }
        return ch;
    }

    /**
     * Bỏ dấu 1 chuỗi
     *
     * @param s
     * @return
     */
    public static String removeAccent(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            sb.setCharAt(i, removeAccent(sb.charAt(i)));
        }
        return sb.toString();
    }

    /**
     * Remove Accents and Diacritics from String
     * Strip Accents from String
     *
     * https://memorynotfound.com/remove-accents-diacritics-from-string/
     *
     * @param input
     * @return
     */
    public static String stripAccents(String input){
        // USE:
        // "\\p{InCombiningDiacriticalMarks}+" matches all diacritic symbols.
        //"[\\p{M}]" matches characters intended to be combined with another character (e.g. accents, umlauts, enclosing boxes, etc.).
        //"[^\\p{ASCII}]" matches all unicode characters.

        return input == null ? null :
                Normalizer.normalize(input, Normalizer.Form.NFD)
                        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                        //.replaceAll("[\\p{M}]", "")
                        //.replaceAll("[^\\p{ASCII}]", "")
                        .replaceAll("Đ", "D")
                        .replace("đ", "d");
    }

    public static String StringToURL(String str) {
        try {
            String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static Date stringToDate(String formatPattern, String strDate) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            return dateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToString(String formatPattern, Date date) {
        DateFormat dateFormat = new SimpleDateFormat(formatPattern);
        return dateFormat.format(date);
    }
    //endregion

    //region DataBase_Methods

    /**
     * <b>Hiếu iceTea 22/04/2020</b> <br>
     * <b>Lấy dữ liệu từ DataBase</b> <br>
     *
     * @param database Tên của cơ sở dữ liệu
     * @param query Câu lệnh truy vấn
     * @return Trả về ResultSet
     * @author Hiếu
     */
    public static ResultSet executeQuery(String database, String query) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database + "?" +
                            "&serverTimezone=UTC" +
                            "&allowPublicKeyRetrieval=true" +
                            "&useSSL=false",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            return statement.executeQuery(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * <b>Hiếu iceTea 22/04/2020</b> <br>
     * <b>Cập nhật dữ liệu trong DataBase</b> <br>
     *
     * @param database Tên của cơ sở dữ liệu
     * @param query Câu lệnh truy vấn
     * @return Trả về số bản ghi bị ảnh hưởng
     * @author Hiếu
     */
    public static int executeUpdate(String database, String query) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database + "?" +
                            "&serverTimezone=UTC" +
                            "&allowPublicKeyRetrieval=true" +
                            "&useSSL=false",
                    "root",
                    ""
            );

            Statement statement = connection.createStatement();

            return statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    //endregion

    //region Input Methods

    /**
     * <b>Trả về số kiểu INT nhập vào từ bàn phím của console</b>
     * @return
     */
    public static int getInputInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static double getInputDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    /**
     *
     * @return Chuổi String do người dùng nhập vào
     */
    public static String getInputLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * <b>Hiếu iceTea 2020</b> <br>
     * <b>Nhắc người dùng và xác nhận nhấn ENTER để tiếp tục</b>
     */
    public static void pause_PressEnterToContinue() {
        System.out.println("\n\tNhấn phím [Enter] để tiếp tục...");
        try{
            System.in.read();
            //getInputStringLine();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("[ERROR] " + e);
        }
    }

    /**
     * <b>Hiện thị thông báo kèm nội dung xác nhận 1 task</b>
     * @param message Nội dung muốn hiện thị
     * @return {@code true} nếu người dùng xác nhận <br> {@code false} nếu người dùng KHÔNG xác nhận
     */
    public static boolean isConfirm(String message) {
        System.out.print(message + " [Y/N]: ");
        while (true) {
            String confirm = getInputLine();
            switch (confirm) {
                case "Y": case "y":
                    System.out.println("Bạn chọn [CÓ]");
                    return true;
                case "N": case "n":
                    System.out.println("Bạn chọn [KHÔNG]");
                    return false;
                default:
                    System.out.println("[ERROR] Lựa chọn không hợp lệ, mời chọn lại...");
                    break;
            }
        }
    }
    //endregion

    //region Note của Hiếu
    //        while (resultSet.next()) {
//            Field[] fields = Gift.class.getDeclaredFields();
//            for (var item : fields) {
//                gift.setIDBook(resultSet.("IDBook"));
//
//            }
//        }


//    public boolean deepEquals(Object obj, Object anotherObj) throws Exception {
//
//        if (obj == anotherObj) return true;
//        if (obj == null || anotherObj == null) return false;
//        //return false nếu không cùng một class type
//        if (obj.getClass() != anotherObj.getClass()) return false;
//        boolean result = true;
//        //lấy toàn bộ thuộc tính của một lớp từ đối tượng của lớp đó
//        Field[] fields = obj.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            //if (field.get(obj) != field.get(anotherObj)) return false;
//            if (!deepEquals(field.get(obj), field.get(anotherObj))) return false;
//        }
//        return result;
//    }
    //endregion
}
