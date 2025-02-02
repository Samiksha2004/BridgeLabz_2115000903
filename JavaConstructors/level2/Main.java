public class Main {
    public static void main(String[] args) {
        Student student = new Student(101, "Alice", 8.5);
        student.displayStudentDetails();
        
        student.setCGPA(9.0);
        System.out.println("Updated CGPA: " + student.getCGPA());

        PostgraduateStudent pgStudent = new PostgraduateStudent(102, "Bob", 9.2);
        pgStudent.displayPostgraduateDetails();
    }
}

