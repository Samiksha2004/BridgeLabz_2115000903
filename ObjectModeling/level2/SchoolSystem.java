import java.util.*;
class Course{
	private String courseName;
	private List<Student> students;

	public Course(String courseName){
		this.courseName = courseName;
		this.students = new ArrayList<>();
	}
	public void enrollStudent(Student student){
		students.add(student);
	}
	public String getCourseName(){
		return courseName;
        }
	public void displayCourse(){
		System.out.println("Course :"+ courseName);
		System.out.println("Enrolled Students :");
		for(Student student : students){
			System.out.println(" - "+ student.getName());
		}
	}
}
class Student{
	private String name;
	private List<Course> courses;
	
	public Student(String name){
		this.name = name;
		this.courses = new ArrayList<>();
	}
	public String getName(){
		return name;
	}
	public void enrollInCourse(Course course){
		courses.add(course);
		course.enrollStudent(this);

	}
	public void displayStudentCourses(){
		System.out.println("Student :" + name );
		System.out.println("Enrolled courses : " );
		for(Course course : courses){
			System.out.println("-" + course.getCourseName());
		}
	}
}
class School{
	private String schoolName;
	private List<Student> students ;
	
	public School(String schoolName){
		this.schoolName = schoolName;
		this.students = new ArrayList<>();
	} 
	public void addStudent(Student student){
		students.add(student);
	}
	public void displaySchool(){
		System.out.println("School " + schoolName);
		for(Student student : students){
			student.displayStudentCourses();
		}
	}
}
public class SchoolSystem{
	public static void main(String args[]){
		School school = new School("Delhi Public School");
		
		Student s1 = new Student("Alice");
		Student s2 = new Student("Bob");

		school.addStudent(s1);
		school.addStudent(s2);

		Course course1 = new Course("Maths");
		Course course2 = new Course("Science");

		s1.enrollInCourse(course1);
		s1.enrollInCourse(course1);

		s2.enrollInCourse(course1);

		school.displaySchool();

		course1.displayCourse();
		course2.displayCourse();

		
	
	}
}
