class Vehicle {
    private int maxSpeed;
    private String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    private int batteryLevel;

    public ElectricVehicle(int maxSpeed, String model, int batteryLevel) {
        super(maxSpeed, model);
        this.batteryLevel = batteryLevel;
    }

    public void charge() {
        System.out.println(getModel() + " is charging...");
        batteryLevel = 100;
    }

    public void displayBatteryLevel() {
        System.out.println(getModel() + " Battery Level: " + batteryLevel + "%");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelLevel;

    public PetrolVehicle(int maxSpeed, String model, int fuelLevel) {
        super(maxSpeed, model);
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void refuel() {
        System.out.println(getModel() + " is refueling...");
        fuelLevel = 100;
    }

    public void displayFuelLevel() {
        System.out.println(getModel() + " Fuel Level: " + fuelLevel + "%");
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle(200, "Tesla Model 3", 50);
        PetrolVehicle honda = new PetrolVehicle(180, "Honda City", 40);

        tesla.displayInfo();
        tesla.displayBatteryLevel();
        tesla.charge();
        tesla.displayBatteryLevel();

        System.out.println();

        honda.displayInfo();
        honda.displayFuelLevel();
        honda.refuel();
        honda.displayFuelLevel();
    }
}

