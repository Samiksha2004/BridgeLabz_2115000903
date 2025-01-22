import java.util.Scanner;

class AthleteRun {

   public static void main(String[] args) {

      Scanner input = new Scanner(System.in);

      int side1 = input.nextInt();
      int side2 = input.nextInt();
      int side3 = input.nextInt();

      int perimeter = side1 + side2 + side3;
      double distanceInMeters = 5000;  // 5 km = 5000 meters

      double rounds = distanceInMeters / perimeter;

      System.out.println("The total number of rounds the athlete will run is " + rounds);

     
   }
}

