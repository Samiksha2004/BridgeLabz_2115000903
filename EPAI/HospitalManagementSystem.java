import java.util.*;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    
    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getDiagnosis() {
        return diagnosis;
    }
    
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public abstract double calculateBill();
    
    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Diagnosis: " + diagnosis;
    }
}

interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> records = new ArrayList<>();
    
    public InPatient(String patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }
    
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }
    
    public void addRecord(String record) {
        records.add(record);
    }
    
    public String viewRecords() {
        return "Medical Records: " + String.join(", ", records);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records = new ArrayList<>();
    
    public OutPatient(String patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }
    
    public double calculateBill() {
        return consultationFee;
    }
    
    public void addRecord(String record) {
        records.add(record);
    }
    
    public String viewRecords() {
        return "Medical Records: " + String.join(", ", records);
    }
}

public class HospitalManagementSystem {
    public static void processPatients(List<Patient> patients) {
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails() + ", Bill Amount: " + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                System.out.println(((MedicalRecord) patient).viewRecords());
            }
        }
    }
    
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        
        InPatient inPatient = new InPatient("P001", "John Doe", 45, "Pneumonia", 5, 2000);
        OutPatient outPatient = new OutPatient("P002", "Jane Smith", 30, "Flu", 500);
        
        inPatient.addRecord("Admitted to ICU");
        outPatient.addRecord("Prescribed antibiotics");
        
        patients.add(inPatient);
        patients.add(outPatient);
        
        processPatients(patients);
    }
}


