import java.util.*;
class Employee{
	private String name;
	
	public Employee(String name){
		this.name = name;
	}
	public void displayEmployee(){
		System.out.println("Employee : " + name);
	}
	
}
class Department{
	private String deptName;
	private List<Employee> employees;

	public Department(String deptName){
		this.deptName = deptName;
		this.employees = new ArrayList<>();
	}
	public void addEmployee(String empName){
		employees.add(new Employee(empName));
	}
	public void displayDepartment(){
		System.out.println("Department : " + deptName);
		for(Employee emp : employees){
			emp.displayEmployee();
		
		}
	}
}
class Company{
	private String companyName ; 
	private List<Department> departments ; 
	
	public Company(String companyName){
		this.companyName = companyName;
		this.departments = new ArrayList<>();
	}
	public void addDepartment(String deptName){
		departments.add(new Department(deptName));
	}
	public void addEmployeeToDepartment(String deptName,String empName){
		for(Department dept : departments){
			if(deptName.equals(deptName)){
				dept.addEmployee(empName);
				break;
			}
		}
	}
	public void displayCompany(){
		System.out.println("Company Name :" + companyName);
		for(Department dept : departments){
			dept.displayDepartment();
		}
	}
}
public class CompanySystem{
	public static void main(String args[]){
		Company company = new Company("Capgemini");
		
		company.addDepartment("IT");
		company.addDepartment("HR");

		company.addEmployeeToDepartment("IT", "Alice");
	        company.addEmployeeToDepartment("IT", "Bob");
        	company.addEmployeeToDepartment("HR", "Charlie");

       		 company.displayCompany();
	}
}
