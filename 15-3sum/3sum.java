import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // Define a method to find all unique triplets that sum to zero.
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the input array to efficiently handle duplicates and use the two-pointer approach.
        Arrays.sort(nums);
        // Initialize a list to store the resulting triplets.
        List<List<Integer>> result = new ArrayList<>();
        // Get the length of the sorted array.
        int n = nums.length;

        // Iterate through the array with the first pointer 'i'.
        // We only need to go up to n-3 because we need at least two more elements for a triplet.
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate elements for the first number of the triplet.
            // If the current element is the same as the previous one, continue to the next iteration.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Initialize two pointers: 'left' starts just after 'i', and 'right' starts at the end of the array.
            int left = i + 1;
            int right = n - 1;

            // Use the two-pointer approach to find the remaining two numbers.
            while (left < right) {
                // Calculate the sum of the current triplet.
                int currentSum = nums[i] + nums[left] + nums[right];

                // If the sum is zero, we found a valid triplet.
                if (currentSum == 0) {
                    // Add the triplet to the result list.
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate elements for the second number of the triplet.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate elements for the third number of the triplet.
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers inwards to find other potential triplets.
                    left++;
                    right--;
                }
                // If the sum is less than zero, we need a larger sum.
                // Move the 'left' pointer to the right to include a larger number.
                else if (currentSum < 0) {
                    left++;
                }
                // If the sum is greater than zero, we need a smaller sum.
                // Move the 'right' pointer to the left to include a smaller number.
                else {
                    right--;
                }
            }
        }

        // Return the list of unique triplets that sum to zero.
        return result;
    }
}