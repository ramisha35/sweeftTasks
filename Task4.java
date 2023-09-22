public class Task4 {
    public static void main(String[] args) {
        System.out.println(binaryAdd("1010", "1011")); //One of the test cases
    }

    static String binaryAdd(String a, String b) {
        // Use a StringBuilder because strings are immutable and StringBuilder is more efficient for string concatenation
        StringBuilder answer = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int currSum = carry;
            if (i >= 0) {
                currSum = currSum + (a.charAt(i) - '0');
                i--;
            }
            if (j >= 0) {
                currSum = currSum + (b.charAt(j) - '0');
                j--;
            }
            answer.insert(0, currSum % 2);
            carry = currSum / 2;
        }
        // If there's a remaining carry, append it to the answer
        if (carry > 0) {
            answer.insert(0, carry);
        }
        return answer.toString();
    }
}