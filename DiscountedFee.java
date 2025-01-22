import java.util.Scanner;

public class DiscountedFee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the student fee: ");
        double fee = input.nextDouble();

        System.out.print("Enter the discount percent: ");
        double discountPercent = input.nextDouble();

        double discount = (fee * discountPercent) / 100;

        double finalFee = fee - discount;

        System.out.println("The discount amount is INR " + discount + " and the final discounted fee is INR " + finalFee);

       
    }
}

