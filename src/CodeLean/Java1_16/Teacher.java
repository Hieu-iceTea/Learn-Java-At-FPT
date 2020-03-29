package CodeLean.Java1_16;

public class Teacher extends Person {
    private int numCourses;
    private String[] courses;
    private static final int MAX_COURSES = 5;

    public Teacher(String name, String address) {
        super(name, address);
        numCourses = 0;
        courses = new String[MAX_COURSES];
    }

    @Override
    public String toString() {
        return String.format("Teacher: %s", super.toString());
    }

    public boolean addCourse(String course){
        for (int i = 0; i < numCourses; ++i){
            if (course.equals(this.courses[i])){
                return false;
            }
        }

        this.courses[numCourses] = course;
        ++numCourses;
        return true;
    }

    public boolean removeCourse(String course) {
        boolean found = false;
        for(int i = 0; i < numCourses; ++i){
            if (!found && course.equals(this.courses[i])){
                --numCourses;
                found = true;
            }
            if (found){
                this.courses[i] = this.courses[i+1];
            }
        }
        return found;
    }
}

