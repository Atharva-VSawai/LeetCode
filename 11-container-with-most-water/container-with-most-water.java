
class Solution {
    // Calculates the maximum area of water a container can store
    public int maxArea(int[] height) {
        // Initialize the maximum area tracker to zero
        int max_water = 0;
        // Initialize a pointer at the beginning of the array
        int left = 0;
        // Initialize a pointer at the end of the array
        int right = height.length - 1;
        // Process elements while pointers have not met
        while (left < right) {
            // Find the height of the container which is limited by the shorter line
            int current_h = Math.min(height[left], height[right]);
            // Update the maximum water area by multiplying current height with the current width
            max_water = Math.max(max_water, current_h * (right - left));
            // Move the pointer that points to the shorter line inward to seek a larger height
            if (height[left] < height[right]) {
                // Shift the left pointer forward
                left++;
            // Handle the case where the right line is shorter or equal
            } else {
                // Shift the right pointer backward
                right--;
            }
        }
        // Return the highest recorded volume
        return max_water;
    }
}