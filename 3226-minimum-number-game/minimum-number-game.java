class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        int ans[] = new int[nums.length];
        for(int num : nums){
            pq.offer(num);
        }
        int ind = 0;
        while(pq.size()!=0){
            int a = pq.poll();
            int b = pq.poll();
            ans[ind++] = b;
            ans[ind++] = a;
        }
        return ans;
    }
}