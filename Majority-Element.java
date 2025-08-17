import java.util.*;

class Solution {
    // Method 2: Sorting and taking the middle index
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}