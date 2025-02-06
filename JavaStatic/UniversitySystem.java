import java.util.*;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void displayFaculty() {
        System.out.println("Faculty: " + name);
    }
}

class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
    }
}

class University {
    private String universityName;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void displayUniversity() {
        System.out.println("University: " + universityName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
        for (Faculty faculty : faculties) {
            faculty.displayFaculty();
        }
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University("GLA University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mathematics");

        Faculty f1 = new Faculty("Vinay Agarawal");
        Faculty f2 = new Faculty("Dr. Umesh");

        university.addFaculty(f1);
        university.addFaculty(f2);

        university.displayUniversity();
    }
}

