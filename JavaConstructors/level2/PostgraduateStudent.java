public class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student - Roll Number: " + rollNumber + ", Name: " + name + ", CGPA: " + getCGPA());
    }
}

