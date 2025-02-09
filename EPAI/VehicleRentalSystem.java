import java.util.*;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public String getType() {
        return type;
    }
    
    public double getRentalRate() {
        return rentalRate;
    }
    
    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }
    
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }
    
    public String getInsuranceDetails() {
        return "Car Insurance: 5% of rental rate";
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }
    
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    
    public double calculateInsurance() {
        return getRentalRate() * 0.02;
    }
    
    public String getInsuranceDetails() {
        return "Bike Insurance: 2% of rental rate";
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }
    
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2;
    }
}

public class VehicleRentalSystem {
    public static void printRentalDetails(List<Vehicle> vehicles, int days) {
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(days);
            double insuranceCost = vehicle instanceof Insurable ? ((Insurable) vehicle).calculateInsurance() : 0;
            double totalCost = rentalCost + insuranceCost;
            
            System.out.println("Vehicle: " + vehicle.getType() + ", Rental Cost: " + rentalCost + ", Total Cost: " + totalCost);
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
            }
        }
    }
    
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        
        Car car = new Car("CAR123", 1000);
        Bike bike = new Bike("BIKE456", 500);
        Truck truck = new Truck("TRUCK789", 2000);
        
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);
        
        printRentalDetails(vehicles, 5);
    }
}

