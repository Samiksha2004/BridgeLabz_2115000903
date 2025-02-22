public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        return ssn.matches(regex);
    }

    public static void main(String[] args) {
        String[] testSSNs = {
            "123-45-6789", // Valid
            "123456789",   // Invalid
            "000-00-0000", // Technically matches format, but usually invalid in real-world usage
            "12-345-6789"  // Invalid (missing one digit in first group)
        };

        for (String ssn : testSSNs) {
            System.out.println(ssn + " → " + (isValidSSN(ssn) ? "Valid" : "Invalid"));
        }
    }
}
