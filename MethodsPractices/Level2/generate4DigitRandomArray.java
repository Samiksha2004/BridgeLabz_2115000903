public class RandomValues {

    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = (int) (Math.random() * 9000) + 1000;
        }
        return randomNumbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        double sum = 0;
        
        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        
        double average = sum / numbers.length;
        return new double[] {average, min, max};
    }

    public static void main(String[] args) {
        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);
        
        double[] results = findAverageMinMax(randomNumbers);
        
        System.out.println("Random 4-digit numbers:");
        for (int number : randomNumbers) {
            System.out.println(number);
        }
        
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + results[1]);
        System.out.println("Maximum: " + results[2]);
    }
}
