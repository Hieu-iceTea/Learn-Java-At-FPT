package Exam.Practice_JAVA2.Model;

/**
 <b>Nguyễn Đình Hiếu - 28/04/2020</b>
 */
public class Student {
    private int IDStudent;
    private String Name;
    private String Address;
    private String Phone;

    public Student() {
        //Nothing
    }

    public Student(int IDStudent, String name, String address, String phone) {
        this.IDStudent = IDStudent;
        Name = name;
        Address = address;
        Phone = phone;
    }

    public int getIDStudent() {
        return IDStudent;
    }

    public void setIDStudent(int IDStudent) {
        this.IDStudent = IDStudent;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-30s %-30s %-15s", IDStudent, Name, Address, Phone);
    }
}
