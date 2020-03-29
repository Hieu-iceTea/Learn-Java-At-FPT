package CodeLean.Java1_16;

public class Student extends Person {
    private int numCourses;
    private String[] courses;
    private int[] grades;
    private static final int MAX_COURSES = 30;

    public Student(String name, String address) {
        super(name, address);
        this.numCourses = 0;
        this.courses = new String[MAX_COURSES];
        this.grades = new int[MAX_COURSES];
    }

    public void addCourseGrade(String course, int grade) {
        this.courses[this.numCourses] = course;
        this.grades[this.numCourses] = grade;
        ++numCourses;
    }

    public void printGrades() {
        //System.out.print(this);

        String result = this + " "; //Tương đương this.toString();

        for (int i = 0; i < numCourses; i++){
            result += courses[i] + ": " + grades[i];
            if (i != numCourses-1){
                result += ", ";
            }
        }

        System.out.println(result);
    }

    public double getAverageGrade() {
        double sumGrade = 0;

        for (int i = 0; i < numCourses; i++) {
            sumGrade += grades[i];
        }

        return sumGrade/numCourses;
    }

    @Override
    public String toString() {
        return String.format("Student: %s", super.toString());
    }
}
