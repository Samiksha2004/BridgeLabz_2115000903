import java.util.*;

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + professor.getName());
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
}

class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public void displayStudentCourses() {
        System.out.println("Student: " + name);
        System.out.println("Enrolled in courses:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class UniManagement {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        Course course1 = new Course("Computer Science 101");
        Course course2 = new Course("Data Structures");

        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        student1.enrollCourse(course1);
        student1.enrollCourse(course2);

        student2.enrollCourse(course2);

        course1.displayCourseDetails();
        course2.displayCourseDetails();

        student1.displayStudentCourses();
        student2.displayStudentCourses();
    }
}

