public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        return color.matches(regex);
    }

    public static void main(String[] args) {
        String[] testColors = { "#FFA500", "#ff4500", "#123", "#zzz999", "#FF450Z" };
        for (String color : testColors) {
            System.out.println(color + " → " + (isValidHexColor(color) ? "Valid" : "Invalid"));
        }
    }
}
