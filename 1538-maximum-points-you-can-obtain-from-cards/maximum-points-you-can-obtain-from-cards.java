class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, rightSum = 0, max = 0;

        for(int i = 0; i< k; i++){
            leftSum += cardPoints[i];
        }
        max = leftSum;

        int rightIndex = cardPoints.length - 1;

        for(int j = k-1 ; j>=0; j--){
            leftSum -= cardPoints[j];
            rightSum += cardPoints[rightIndex--];
            max = Math.max(max, leftSum + rightSum);
        }

        return max;
    }
}