package Exam.Practice_JAVA1;

public class EmployeeFullTime extends SalaryPolicy {
    private float rate;

    public EmployeeFullTime() {
        this.rate = 4;
    }

    public EmployeeFullTime(float baseSalary) {
        super(baseSalary);
        this.rate = 4;
    }

    @Override
    float getSalary() {
        return this.rate * super.getBaseSalary();
    }
}
