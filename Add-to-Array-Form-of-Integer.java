class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = num.length - 1;
        
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];  // add current digit to k
                i--;
            }
            result.addFirst(k % 10); // last digit
            k /= 10;                 // reduce k
        }
        
        return result;
    }
}
