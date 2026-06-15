class Solution {

    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();

    // Edge case: empty input
    if (digits == null || digits.length() == 0) {
        return result;
    }

    // Start backtracking from the 0-th index
    backtrack(digits, 0, new StringBuilder(), result);
    return result;
}

private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
    // Base case: if the current combination is of the same length as digits
    if (index == digits.length()) {
        result.add(current.toString());
        return;
    }

    // Get the letters corresponding to the current digit
    char digitChar = digits.charAt(index);
    String letters = KEYPAD[digitChar - '0'];

    // Loop through all possible letters for the current digit
    for (int i = 0; i < letters.length(); i++) {
        char letter = letters.charAt(i);

        current.append(letter);                  // Choose
        backtrack(digits, index + 1, current, result); // Explore
        current.deleteCharAt(current.length() - 1); // Backtrack (Undo Choose)
    }
}
}