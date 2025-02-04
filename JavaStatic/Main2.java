public class Main2{
	public static void main(String args[]){
		Employee emp1 = new Employee(101, "Samiksha", "Software Engineer");
		Employee emp2 = new Employee(102, "Saniya Gupta", "Data Analyst");

		System.out.println("\n Employee 1 details");
		emp1.displayEmployeeDetails();
			
		System.out.println();
		
		System.out.println("\n Employee 2 details");
		emp2.displayEmployeeDetails();
	
	}
}
