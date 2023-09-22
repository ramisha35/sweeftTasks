public class Task1 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        System.out.println(singleNumber(nums)); //One of the test cases
    }

/* The condition is a bit confusing if it means that
each value in the array is equal to 2, except for one value,
then xor operation is better than my second method,
 depending on memory and time complexity. */

    static int singleNumber(int[] nums) {
        int result = 0;
        for (int curr : nums) {
            result = result ^ curr;
        }
        return result;
    }

   /* As for the second method,
   which is the solution of the same problem,
   it is for the case if the same values are not 2 but any number,
   and we are asked for the value when one of the values in the array is 1 */

  /*  static int singleNumber(int[] nums){
        if(nums.length == 0)return -1; // edge case
        HashMap< Integer, Integer > numberCounts = new HashMap <>();
        for(int i = 0; i < nums.length; i++){
            if(!numberCounts.containsKey(nums[i])){
                numberCounts.put(nums[i],1);
            }else{
                int appropriateCount = numberCounts.get(nums[i]);
                int newAppropriateCount = appropriateCount + 1;
                numberCounts.remove(nums[i]);
                numberCounts.put(nums[i],newAppropriateCount);
            }
        }
        for(Map.Entry< Integer, Integer > entry : numberCounts.entrySet()){
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return -1;
    }
*/

}