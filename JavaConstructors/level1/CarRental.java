public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate = 50.0;  // Example daily rate for rental

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("John Doe", "Toyota Corolla", 5);
        CarRental rental2 = new CarRental("Jane Smith", "Honda Civic", 3);

        System.out.println("Customer: " + rental1.getCustomerName() + ", Car: " + rental1.getCarModel() + ", Total Cost: $" + rental1.calculateTotalCost());
        System.out.println("Customer: " + rental2.getCustomerName() + ", Car: " + rental2.getCarModel() + ", Total Cost: $" + rental2.calculateTotalCost());
    }
}

