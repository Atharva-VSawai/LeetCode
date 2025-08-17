import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums); // sort in ascending order
        
        int distinctCount = 1; // at least the largest exists
        int current = nums[nums.length - 1]; // start from the max
        
        // Traverse from second last to beginning
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != current) { // found a new distinct number
                distinctCount++;
                current = nums[i];
            }
            if (distinctCount == 3) { 
                return current; // return 3rd distinct maximum
            }
        }
        
        // if less than 3 distinct numbers → return maximum
        return nums[nums.length - 1];
    }
}
