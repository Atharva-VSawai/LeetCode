class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int ans = 0;
        boolean odd = false;

        for(int count: map.values()){
            if(count%2==0){
                ans+=count;
            } else{
                ans += count-1;
                odd = true;
            }
        }

        if(odd){
            ans++;
        }
        return ans;
    }
    
}