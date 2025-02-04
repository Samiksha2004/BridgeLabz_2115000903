public class Student{
	private static String universityName = "GLA University";
	private static int totalStudents = 0;

	private final int rollNumber;
	private String  name;
	private String grade;

	public Student(int rollNumber,String name,String grade){
		this.rollNumber = rollNumber ; 
		this.name = name ;
		this.grade = grade;
		totalStudents++;
	}
	public static void displayTotalStudents(){
		System.out.println("Total Students Enrolled : " + totalStudents);
	}
	public void updateGrade(String newGrade){
		if(this instanceof Student){
		 this.grade = newGrade;
		 System.out.println("Updated grade for " + name + " (Roll No : " + rollNumber + ") to "+ grade);
	        }	
	}
	public void displayStudentDetails(){
		if(this instanceof Student){
			System.out.println("Student Roll No : " + rollNumber);
			System.out.println("Student name : " + name);
			System.out.println("Student Grade : " + grade);
			System.out.println("University Name : " + universityName);
		}
	}
}

