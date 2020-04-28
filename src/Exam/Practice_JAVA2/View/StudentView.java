package Exam.Practice_JAVA2.View;

import Exam.Practice_JAVA2.Controller.StudentController;
import Exam.Practice_JAVA2.Model.Student;
import MyUtilities.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 <b>Nguyễn Đình Hiếu - 28/04/2020</b>
 */
public class StudentView {
    public static void RunMenu() {
        List<Student> listStudent = new ArrayList<>();

        try {
            while (true) {
                System.out.print("\n _ _ _ _ _ _ _ _ Menu _ _ _ _ _ _ _ _\n" +
                        "| 1. Add student records               |\n" +
                        "| 2. Display student records           |\n" +
                        "| 3. Save                              |\n" +
                        "| 0. Exit                              |\n" +
                        "  => Bạn chọn: ");
                int chose = Utility.getInputInt();
                System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");

                switch (chose) {
                    case 1:
                        //addNewStudent();
                        addNewStudent(listStudent);
                        break;
                    case 2:
                        //viewStudent();
                        viewStudent(listStudent);
                        break;
                    case 3:
                        saveStudent(listStudent);
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

    private static void addNewStudent(List<Student> listStudent) {
        Student student = new Student();

        System.out.println("Mời nhập các thông tin cho sinh viên: ");

        System.out.print("Name: ");
        String Name = Utility.getInputLine();
        student.setName(Name);

        System.out.print("Address: ");
        String Address = Utility.getInputLine();
        student.setAddress(Address);

        System.out.print("Phone: ");
        String Phone = Utility.getInputLine();
        student.setPhone(Phone);

        if (Utility.isConfirm("Xác nhận thêm 1 bản ghi? ")) {
            listStudent.add(student);
            System.out.println("Thêm thành công");
        }
    }

    private static void viewStudent(List<Student> listStudent) {
        StudentController studentController = new StudentController();
        List<Student> listStudent_DB = studentController.selectAllColumn();

        System.out.println("Danh sach sinh vien: ");
        for (var item : listStudent_DB) {
            System.out.println(item);
        }

        if (listStudent.isEmpty()) return;

        System.out.println("Danh sach sinh vien (Chưa lưu): ");
        for (var item : listStudent) {
            System.out.println(item);
        }
    }

    private static void saveStudent(List<Student> listStudent) {
        if (listStudent.isEmpty()) {
            System.out.println("Không có gì để lưu");
            return;
        }

        if (Utility.isConfirm("Xác nhận lưu tất cả bản ghi? ")) {
            StudentController studentController = new StudentController();
            studentController.insertItems(listStudent);
            listStudent.clear();
        }
    }

    /**
     * Cách cũ
     * @deprecated
     */
    @Deprecated
    private static void addNewStudent() {
        Student student = new Student();

        System.out.println("Mời nhập các thông tin cho sinh viên: ");

        System.out.print("Name: ");
        String Name = Utility.getInputLine();
        student.setName(Name);

        System.out.print("Address: ");
        String Address = Utility.getInputLine();
        student.setAddress(Address);

        System.out.print("Phone: ");
        String Phone = Utility.getInputLine();
        student.setPhone(Phone);

        if (Utility.isConfirm("Xác nhận thêm 1 bản ghi? ")) {
            StudentController studentController = new StudentController();
            studentController.insertItem(student);
            System.out.println("Thêm thành công");
        }
    }

    /**
     * Cách cũ
     * @deprecated
     */
    @Deprecated
    private static void viewStudent() {
        StudentController studentController = new StudentController();
        List<Student> lstStudent = studentController.selectAllColumn();

        System.out.println("Danh sach sinh vien: ");
        for (var item : lstStudent) {
            System.out.println(item);
        }
    }
}
