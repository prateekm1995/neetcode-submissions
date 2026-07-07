class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        int ans=0;
        for( int num : nums){
            set.add(num);
        }

        for(int num : nums){
            if(!set.contains(num-1)){
                int temp = 1;
                while(set.contains(num+temp)){
                    temp++;
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}
