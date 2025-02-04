public class Vehicle{
	private static double registrationFee = 5000.0 ; 
	
	private final String registrationNumber;
	private String ownerName;
	private String vehicleType;

	public Vehicle(String registrationNumber,String ownerName,String vehicleType){
		this.registrationNumber = registrationNumber;
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
	}
	public static void updateRegistrationFee(double newFee){
		registrationFee = newFee;
		System.out.println("updated Registration Fee :"+ registrationFee);
	
	}
	public void displayVehicleDetails(){
		if(this instanceof Vehicle){
			System.out.println("Registration Number : " + registrationNumber);
			System.out.println("Owner Name : "+ 	ownerName );
			System.out.println("Vehicle Type : " + vehicleType);
			System.out.println("Registration fee : " + registrationFee );
			
		}
	}
}
