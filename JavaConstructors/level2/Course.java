public class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "ABC Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " months, Fee: " + fee + ", Institute: " + instituteName);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 6, 300.0);
        Course course2 = new Course("Data Science", 8, 400.0);

        course1.displayCourseDetails();
        course2.displayCourseDetails();

        Course.updateInstituteName("XYZ Academy");
        
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}

