package CodeLean;


public class Java1_12 {
    public static void main(String[] args) {
        //testAccount();
        //testTime();
    }

    public static void testAccount(){
        Account a1 = new Account(868663315, 9999);
        Account a2 = new Account(123456);

        System.out.println(a1); //.toString()
        System.out.println(a2); //.toString()

        a2.credit(5000);
        a1.debit(99);

        a1.debit(99999); //Thông báo lỗi k đủ tiền

        System.out.println(a1); //.toString()
        System.out.println(a2); //.toString()

        a1.transferTo(100, a2);

        a1.transferTo(10000, a2); //Thông báo lỗi k đủ tiền

        System.out.println(a1); //.toString()
        System.out.println(a2); //.toString()
    }

    public static void testTime() {
        Time t1 = new Time(59, 59, 23);
        System.out.println(t1);

        try {
            Time t2 = new Time(60, 59, 12);
            System.out.println("Lock good!"); //This line will be skipped, if exception occurs
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        System.out.println("Continue after exception!");
    }
}

class Account {
    private int number;
    private double balance;

    public Account(){
        //none
    }

    public Account(int number){
        this.number = number;
    }

    public Account(int number, double balance){
        this.number = number;
        this.balance = balance;
    }

    public int getNumber(){
        return number;
    }

    public double getBalance(){
        return balance;
    }

    public String toString(){
        return String.format("Account [number = %d, balance = %.2f]", number, balance);
    }

    public void credit(double amount){
        balance = balance + amount;
    }

    public void debit(double amount){
        if (balance >= amount){
            balance = balance - amount;
        } else {
            System.out.println("Error: amount exceeded");
            //throw new IllegalArgumentException("amount exceeded");
        }
    }

    public void transferTo(double amount, Account another){
        if (balance >= amount){
            balance = balance - amount;
            another.credit(amount);
        } else {
            System.out.println("Error: amount exceeded");
        }
    }



}

class Time {
    private int second;
    private int minute;
    private int hour;

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        } else {
            throw new IllegalArgumentException("Invalid second!");
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        } else {
            throw new IllegalArgumentException("Invalid minute!");
        }
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        } else {
            throw new IllegalArgumentException("Invalid hour!");
        }
    }

    public void setTime (int second, int minute, int hour){
        this.setSecond(second);
        this.setMinute(minute);
        this.setHour(hour);
    }

    public Time(){
        //none
    }

    public Time (int second, int minute, int hour){
        this.setTime(second, minute, hour);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public Time nextSecond(){
        ++second;
        if (second == 60){
            second = 0;
            ++minute;
            if (minute == 60){
                minute = 0;
                ++hour;
                if (hour == 24){
                    hour = 0;
                }
            }
        }
        return this;
    }
}

class Student { //copy: https://www.ntu.edu.sg/home/ehchua/programming/java/J3a_OOPBasics.html
    // The private instance variables
    private String name;
    private String address;
    // The courses taken and grades for the courses are kept in 2 parallel arrays
    private String[] courses;
    private int[] grades;     // valid range is [0, 100]
    private int numCourses;   // Number of courses taken so far
    private static final int MAX_COURSES = 30;  // Maximum number of courses taken by student

    /** Constructs a Student instance with the given input */
    public Student(String name, String address) {
        this.name = name;
        this.address = address;
        courses = new String[MAX_COURSES];  // allocate arrays
        grades = new int[MAX_COURSES];
        numCourses = 0;                     // no courses so far
    }

    // The public getters and setters.
    // No setter for name as it is not designed to be changed.
    /** Returns the name */
    public String getName() {
        return this.name;
    }
    /** Returns the address */
    public String getAddress() {
        return this.address;
    }
    /** Sets the address */
    public void setAddress(String address) {
        this.address = address;
    }

    /** Returns a self-descriptive String */
    public String toString() {
        return name + "(" + address + ")";
    }

    /** Adds a course and grade */
    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        ++numCourses;
    }

    /** Prints all courses and their grades */
    public void printGrades() {
        System.out.print(name);
        for (int i = 0; i < numCourses; ++i) {
            System.out.print(" " + courses[i] + ":" + grades[i]);
        }
        System.out.println();
    }

    /** Computes the average grade */
    public double getAverageGrade() {
        int sum = 0;
        for (int i = 0; i < numCourses; ++i) {
            sum += grades[i];
        }
        return (double)sum/numCourses;
    }
}