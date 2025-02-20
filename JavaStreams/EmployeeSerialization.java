import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class implementing Serializable interface
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.println("Enter employee details (type 'done' to finish):");
        while (true) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            employees.add(new Employee(id, name, department, salary));

            System.out.print("Add another employee? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("no")) {
                break;
            }
        }

        // Serialize employee list to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully!");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }

        // Deserialize and display employees
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            @SuppressWarnings("unchecked")
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employees:");
            deserializedEmployees.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
    }
}

