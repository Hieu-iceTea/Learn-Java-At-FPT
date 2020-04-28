package Exam.Practice_JAVA2.Controller;

import Exam.Practice_JAVA2.Model.Student;
import MyUtilities.Utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 <b>Nguyễn Đình Hiếu - 28/04/2020</b>
 */
public class StudentController {
    public List<Student> selectAllColumn() {
        try {
            ResultSet resultSet = Utility.executeQuery("eStudent", "SELECT * FROM Student;");
            List<Student> lstStudent = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setIDStudent(resultSet.getInt("IDStudent"));
                student.setName(resultSet.getString("Name"));
                student.setAddress(resultSet.getString("Address"));
                student.setPhone(resultSet.getString("Phone"));
                lstStudent.add(student);
            }
            return lstStudent;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void insertItem(Student item) {
        String query = "INSERT INTO Student (Name, Address, Phone) " +
                "VALUES ('" + item.getName() + "', '" + item.getAddress() + "', '" + item.getPhone() + "');";
        System.out.println("Câu query của bạn là: \n" +query);

        int recordCount = Utility.executeUpdate("eStudent", query);
        if (recordCount > 0) {
            System.out.println("Thành công! Số bản ghi bị ảnh hưởng: " + recordCount);
        } else {
            System.out.println("Lỗi!  Số bản ghi bị ảnh hưởng: " + recordCount);
        }
    }

    public void insertItems(List<Student> listItem) {
        String query = "INSERT INTO Student (Name, Address, Phone) VALUES ";

        for (int i = 0; i < listItem.size(); ++i) {
            query += "\n ('" + listItem.get(i).getName() + "', '" +
                    listItem.get(i).getAddress() + "', '" +
                    listItem.get(i).getPhone() + "')";

            if (i != listItem.size() - 1) {
                query += ",";
            }
        }

        System.out.println("Câu query của bạn là: \n" +query);

        int recordCount = Utility.executeUpdate("eStudent", query);
        if (recordCount > 0) {
            System.out.println("Thành công! Số bản ghi bị ảnh hưởng: " + recordCount);
        } else {
            System.out.println("Lỗi!  Số bản ghi bị ảnh hưởng: " + recordCount);
        }
    }
}
