package Exam.Practice_JAVA1;

public abstract class SalaryPolicy {
    private float baseSalary;

    public SalaryPolicy() {
        //nothing
    }

    public SalaryPolicy(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    abstract float getSalary();
}
