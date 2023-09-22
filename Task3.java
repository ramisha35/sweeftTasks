import java.util.HashMap;

public class Task3 {
    public static void main(String[] args) {
        int[] array = {-1, -32, -231, 0, 1, 2, 3, 5, 4, 7};
        System.out.println(notContains(array)); //One of the test cases
    }

    static int notContains(int[] array) {
        if (array.length == 0) return 1;  // Edge case: if the array is empty, return 1
        int maxNumber = Integer.MIN_VALUE;
        // Find the maximum number in the array
        for (int i = 0; i < array.length; i++) {
            if (maxNumber < array[i]) {
                maxNumber = array[i];
            }
        }
        // If the maximum number is less than or equal to 0, return 1
        if (maxNumber <= 0) return 1;
        // Create a HashMap to track the presence of positive integers from 1 to maxNumber
        HashMap<Integer, Integer> existingNumber = new HashMap<>();
        //Initialize the HashMap with -1 values, indicating that no numbers are found yet
        for (int i = 1; i <= maxNumber; i++) {
            existingNumber.put(i, -1);
        }
        //Iterate through the input array and mark positive integers as found in the HashMap
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                existingNumber.put(array[i], 1);
            }
        }
        // Iterate through the HashMap and find the first missing positive integer
        for (int i = 1; i <= maxNumber; i++) {
            if (existingNumber.get(i) == -1) {
                return i;
            }
        }
        // If all positive integers from 1 to maxNumber are found, return maxNumber + 1
        return maxNumber + 1;
    }
}