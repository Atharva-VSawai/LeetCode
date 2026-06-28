import java.util.*;

class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxPro = Math.max(maxPro, prices[i] - minPrice);
            }
        }

        return maxPro;
    }
}