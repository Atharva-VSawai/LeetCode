import java.util.Arrays;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        // Sort the array using a custom comparator
        Arrays.sort(nums, (a, b) -> {
            // If lengths differ, the longer number is larger
            if (a.length() != b.length()) {
                return b.length() - a.length(); // Descending order
            } else {
                // If lengths are same, compare lexicographically
                return b.compareTo(a); // Descending order
            }
        });

        // Return the k-th largest element (0-based index, so k-1)
        return nums[k - 1];
    }
}
