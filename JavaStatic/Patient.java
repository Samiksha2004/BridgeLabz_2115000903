public class Patient{
	private static String hospitalName = "City Hospital";
	private static int totalPatients = 0;
	
	private final int patientId;
	private String name;
	private int age;
	private String ailment;

	public Patient(int patientId,String name,int age,String ailment){
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		totalPatients++;
	}
	public static int getTotalPatients(){
		return totalPatients;
	}
	public void displayPatientDetails(){
		if(this instanceof Patient){
			System.out.println("Patient ID: " + patientId);
                        System.out.println("Name: " + name);
                        System.out.println("Age: " + age);
                        System.out.println("Ailment: " + ailment);
                        System.out.println("Hospital: " + hospitalName);
                        System.out.println();
		}
	}
	public static void setHospitalName(String newHospitalName){
		hospitalName = newHospitalName;
		
		
	}
}
