public class Employee{
	private static String companyName = "Capgemini";
	private static int totalEmployees = 0;
	private final int id;
	private String name;
	private String designation;

	public Employee(int id,String name,String designation){
		this.id = id;
		this.name = name;
		this.designation = designation;
		totalEmployees++;
	}
	public static void displayTotalEmployees(){
		System.out.println("Total Employee :"+ totalEmployees);
	

	}
	public void displayEmployeeDetails(){
		System.out.println("ID : " + id);
		System.out.println("Name : " + name);
		System.out.println("Designation : " + designation);
		System.out.println("Company Name : "+ companyName);
	
	}
}
