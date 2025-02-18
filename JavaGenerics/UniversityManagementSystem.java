import java.util.ArrayList;
import java.util.List;

// Abstract Course Type (Base Class)
abstract class CourseType {
    private String typeName;

    public CourseType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return getTypeName();
    }
}

// Specific Course Types
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

// Generic Course Class
class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course: " + courseName + " | Department: " + department + " | Type: " + courseType;
    }
}

// University Course Management System
class University {
    private List<Course<?>> courses = new ArrayList<>();

    public void addCourse(Course<?> course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("\n--- University Courses ---");
        for (Course<?> course : courses) {
            System.out.println(course);
        }
    }

    // Wildcard Method to Handle Any Course Type
    public static void showCourses(List<? extends CourseType> courseList) {
        System.out.println("\n--- Available Course Types ---");
        for (CourseType course : courseList) {
            System.out.println(course);
        }
    }
}

// Main Class: Demonstration
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create different types of courses
        Course<ExamCourse> math = new Course<>("Mathematics", "Science", new ExamCourse());
        Course<AssignmentCourse> literature = new Course<>("English Literature", "Arts", new AssignmentCourse());
        Course<ResearchCourse> physics = new Course<>("Quantum Physics", "Engineering", new ResearchCourse());

        // University System
        University university = new University();
        university.addCourse(math);
        university.addCourse(literature);
        university.addCourse(physics);

        // Display courses
        university.displayCourses();

        // Create a list of course types
        List<CourseType> courseTypes = List.of(new ExamCourse(), new AssignmentCourse(), new ResearchCourse());

        // Display course types using wildcard method
        University.showCourses(courseTypes);
    }
}
