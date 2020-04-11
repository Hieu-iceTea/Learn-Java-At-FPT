package Exam.Practice_JAVA1;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {

    /** Create two objects EmployeeFullTime and EmployeePartime. */
        EmployeeFullTime employeeFullTime1 = new EmployeeFullTime();
        EmployeePartime employeePartime1 = new EmployeePartime();

    /** Ask user to Input base salary for each object */
        float baseSalary_employeeFullTime1;
        float baseSalary_employeePartime1;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter base Salary employee FullTime: ");
        baseSalary_employeeFullTime1 = input.nextFloat();
        employeeFullTime1.setBaseSalary(baseSalary_employeeFullTime1);

        System.out.print("Enter base Salary employee Partime: ");
        baseSalary_employeePartime1 = input.nextFloat();
        employeePartime1.setBaseSalary(baseSalary_employeePartime1);

    /** Print salary for each object. */
        System.out.println("Print salary for employee FullTime: " + employeeFullTime1.getSalary());
        System.out.println("Print salary for employee Partime: " + employeePartime1.getSalary());
    }
}
