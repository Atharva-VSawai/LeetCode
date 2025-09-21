class Solution {
    public int maxDepth(String s) {
        int currCount = 0;
        int maxCount = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '('){
                currCount++;
                if(currCount > maxCount) {
                    maxCount = currCount;
                }
            }
            if(s.charAt(i) == ')') {
                currCount--;
            }
        }
        return maxCount;
    }
}