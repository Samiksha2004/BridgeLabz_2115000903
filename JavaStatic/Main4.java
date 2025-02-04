public class Main4{
	public static void main(String args[]){
		Student s1 = new Student(101 , "Samiksha" , "A");
		Student s2 = new Student(102 , "Saniya Gupta" , "O");

		System.out.println("Student details before Grade update");

		s1.displayStudentDetails();
		s2.displayStudentDetails();

		Student.displayTotalStudents();

		s1.updateGrade("O");
		s2.updateGrade("A");

		System.out.println("Student details after grade update");
		
		s1.displayStudentDetails();
		s2.displayStudentDetails();
	}
}
