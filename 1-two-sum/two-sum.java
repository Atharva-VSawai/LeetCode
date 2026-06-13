



class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>Hashmap= new HashMap<>();
        for(int i =0; i<nums.length; i++){
            int comp = target - nums[i];
            if(Hashmap.containsKey(comp)){
                return new int[]{Hashmap.get(comp),i};
            }
            Hashmap.put(nums[i],i);
        }
        return new int[]{};
    }
}
