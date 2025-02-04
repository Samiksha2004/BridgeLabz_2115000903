public class Main6{
	public static void main(String args[]){
		Patient p1 = new Patient(101, "John", 35, "Fever");
		Patient p2 = new Patient(102, "Alice Smith", 28, "Flu");

		System.out.println("Patient Details before Hospital name change");

		p1.displayPatientDetails();
		p2.displayPatientDetails();

		Patient.setHospitalName("Global Health centre");
		
		System.out.println("Patient Details after Hospital name change");
		p1.displayPatientDetails();
                p2.displayPatientDetails();

	}
}
