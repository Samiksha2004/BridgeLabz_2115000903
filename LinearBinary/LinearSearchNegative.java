public class LinearSearchNegative {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) { // Check if the number is negative
                return i; // Return index of first negative number
            }
        }
        return -1; // No negative number found
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 0, 5, -2, 8, -5}; // Example array

        int index = findFirstNegative(numbers);

        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}

