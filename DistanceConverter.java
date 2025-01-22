public class DistanceConverter {
    public static void main(String[] args) {
        double distanceInKm = 10.8;
       
        double conversionFactor = 1.6;
        
        double distanceInMiles = distanceInKm * conversionFactor;

        
        System.out.println("The distance " + distanceInKm + " km in miles is " + distanceInMiles);
    }
}
