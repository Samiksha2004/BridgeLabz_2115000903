public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John Doe", 101, 50000);
        Employee emp2 = new Employee("Jane Smith", 102, 60000);

        System.out.println("=== Employee 1 Details ===");
        emp1.displayDetails();

        System.out.println("\n=== Employee 2 Details ===");
        emp2.displayDetails();
    }
}

