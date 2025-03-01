class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return \\;

        String prefix = strs[0]; // Take the first string as reference

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { // Check if prefix is found at the start
                prefix = prefix.substring(0, prefix.length() - 1); // Reduce prefix
                if (prefix.isEmpty()) return \\;
            }
        }
        return prefix;
    }
}