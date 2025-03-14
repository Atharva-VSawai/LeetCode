class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // Increment and return immediately
                return digits;
            }
            digits[i] = 0; // Set to 0 if it's 9 and continue
        }

        // If all digits were 9 (e.g., [9,9,9] → [1,0,0,0])
        int[] result = new int[n + 1];
        result[0] = 1; // Only first digit is 1, rest are default 0s
        return result;
    }
}
