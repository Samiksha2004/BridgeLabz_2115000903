public class CreditCardValidator {
    public static String validate(String cardNumber) {
        if (cardNumber.matches("^4\\d{15}$")) return "Valid Visa";
        if (cardNumber.matches("^5\\d{15}$")) return "Valid MasterCard";
        return "Invalid";
    }

    public static void main(String[] args) {
        String[] testCards = {
            "4111111111111111",
            "5111111111111111",
            "6111111111111111",
            "4",
            "511111111111111"
        };
        for (String card : testCards) {
            System.out.println(card + " → " + validate(card));
        }
    }
}
