public class IPAddressValidator {
    public static boolean isValidIPv4(String ip) {
        String regex = "^(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\."
                     + "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\."
                     + "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)\\."
                     + "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)$";
        return ip.matches(regex);
    }

    public static void main(String[] args) {
        String[] testIPs = {
            "192.168.1.1",
            "255.255.255.255",
            "256.100.100.100",
            "1.1.1",
            "0.0.0.0"
        };
        for (String ip : testIPs) {
            System.out.println(ip + " → " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}
