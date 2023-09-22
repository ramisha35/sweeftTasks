public class Task5 {
    public static void main(String[] args) {
        System.out.println(countVariants(4)); //One of the test cases

    }

    //The code is related to the Fibonacci concept
    static int countVariants(int stearsCount) {
        int[] cntVariants = new int[stearsCount + 1];
        cntVariants[1] = 1;
        cntVariants[2] = 2;
        for (int i = 3; i <= stearsCount; i++) {
            cntVariants[i] = cntVariants[i - 1] + cntVariants[i - 2];
        }
        return cntVariants[stearsCount];
    }

}