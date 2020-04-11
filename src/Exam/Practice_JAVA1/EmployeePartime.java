package Exam.Practice_JAVA1;

public class EmployeePartime extends SalaryPolicy {
    private float rate;

    public EmployeePartime() {
        this.rate = (float) 2.5;
    }

    public EmployeePartime(float baseSalary) {
        super(baseSalary);
        this.rate = (float) 2.5;
    }

    @Override
    float getSalary() {
        return this.rate * super.getBaseSalary();
    }
}
