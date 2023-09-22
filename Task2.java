public class Task2 {
    public static void main(String[] args) {
        System.out.println(minSplit(21)); //One of the test cases
    }

    /* The idea of the task is to use the minimum number of coins that
    I wrote in the array, we just use the coins from the maximum to the minimum until
    we reach the appropriate amount of money, it is quite a simple idea. */
    static int minSplit(int amount) {
        int[] coins = {1, 5, 10, 20, 50};
        int numCoins = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int currCoin = coins[i];
            while (amount >= currCoin) {
                amount = amount - currCoin;
                numCoins++;
            }
        }
        return numCoins;
    }

}