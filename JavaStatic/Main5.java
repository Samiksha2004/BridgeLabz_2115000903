public class Main5{
	public static void main(String args[]){
		Vehicle car = new Vehicle("UP32AB1234", "Samiksha", "Car");
		Vehicle bike = new Vehicle("DL10XY5678", "Saniya Gupta", "Bike");

		System.out.println("Vehicle details before fee update");

		car.displayVehicleDetails();
		bike.displayVehicleDetails();

		Vehicle.updateRegistrationFee(6000);

		System.out.println("Vehicle details after fee update");
		car.displayVehicleDetails();
		bike.displayVehicleDetails();
	}
}
