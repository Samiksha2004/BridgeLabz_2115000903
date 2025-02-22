public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        String regex = "^[A-Z]{2}\\d{4}$";
        return plate.matches(regex);
    }

    public static void main(String[] args) {
        String[] testPlates = { "AB1234", "A12345", "ZZ9999", "ab1234" };
        for (String plate : testPlates) {
            System.out.println(plate + " → " + (isValidLicensePlate(plate) ? "Valid" : "Invalid"));
        }
    }
}
