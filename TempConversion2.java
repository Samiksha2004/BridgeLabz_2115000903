import java.util.Scanner;

public class TempConversion2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double fahrenheit = input.nextDouble();
        
        double celsiusResult = (fahrenheit - 32) * 5 / 9;

        System.out.println("The " + fahrenheit + " fahrenheit is " + celsiusResult + " celsius");
        
        
    }
}

