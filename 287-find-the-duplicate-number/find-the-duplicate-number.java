class Solution {
    public int findDuplicate(int[] nums) {
        // // Step 1: Detect cycle (like linked list)
        // int slow = nums[0];
        // int fast = nums[0];

        // do {
        //     slow = nums[slow];        // move 1 step
        //     fast = nums[nums[fast]];  // move 2 steps
        // } while (slow != fast);

        // // Step 2: Find cycle entry point
        // slow = nums[0];
        // while (slow != fast) {
        //     slow = nums[slow];
        //     fast = nums[fast];
        // }

        // return slow; // duplicate number

        boolean[] checkHas = new boolean[nums.length ];
        for (int num : nums) {
            if (checkHas[num]) return num;
            checkHas[num] = true;
        }
        return 0;
    }
}
