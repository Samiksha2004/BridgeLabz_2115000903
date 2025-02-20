import java.io.*;

class StudentDataStream {
    public static void main(String[] args) {
        String filename = "student_data.dat";

        // Writing student data to a binary file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(101); // Roll Number
            dos.writeUTF("Samiksha"); // Name
            dos.writeDouble(7.8); // GPA

            dos.writeInt(102);
            dos.writeUTF("Saniya Gupta");
            dos.writeDouble(9.1);

            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing to file: " + e.getMessage());
        }

        // Reading student data from the binary file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("GPA: " + gpa);
                System.out.println("--------------------");
            }
        } catch (IOException e) {
            System.out.println("Error while reading from file: " + e.getMessage());
        }
    }
}

