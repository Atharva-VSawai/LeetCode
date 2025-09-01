class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            // map.put(nums[i], map.get(nums[i])==null?1:map.get(nums[i])+1);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);   // Or
        }
        // Set<Integer> keys = map.keySet();
        for(Integer key : map.keySet()){  // or we can write keySet() in loop without storing in set data struct.
            if(map.get(key)>nums.length/3){
                list.add(key);
            }
        }
        return list;
    }
}