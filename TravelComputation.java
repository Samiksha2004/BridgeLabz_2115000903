import java.util.Scanner;

class TravelComputation {

   public static void main(String[] args) {

      Scanner input = new Scanner(System.in);

      String name = input.nextLine();
      String fromCity = input.nextLine();
      String viaCity = input.nextLine();
      String toCity = input.nextLine();

      int distanceFromToVia = input.nextInt();
      int distanceViaToFinalCity = input.nextInt();

      int hoursFromToVia = input.nextInt();
      int minutesFromToVia = input.nextInt();
      int timeFromToVia = hoursFromToVia * 60 + minutesFromToVia;

      int hoursViaToFinalCity = input.nextInt();
      int minutesViaToFinalCity = input.nextInt();
      int timeViaToFinalCity = hoursViaToFinalCity * 60 + minutesViaToFinalCity;

      int totalDistance = distanceFromToVia + distanceViaToFinalCity;
      int totalTime = timeFromToVia + timeViaToFinalCity;
      int distanceTimeDifference = totalDistance - totalTime;
      int distanceTimeProduct = totalDistance * totalTime;

      System.out.println("The results of Int Operations are " + totalDistance + ", " + totalTime + ", and " + distanceTimeProduct);

      
   }
}

