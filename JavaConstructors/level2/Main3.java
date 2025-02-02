public class Main3 {
    public static void main(String[] args) {
        Employee employee = new Employee("E12345", "IT", 60000.0);
        employee.displayEmployeeDetails();
        
        employee.setSalary(65000.0);
        System.out.println("Updated Salary: " + employee.getSalary());

        Manager manager = new Manager("M67890", "HR", 80000.0);
        manager.displayManagerDetails();
    }
}

