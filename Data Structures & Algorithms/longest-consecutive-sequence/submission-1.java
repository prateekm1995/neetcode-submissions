class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for( int i=0 ; i  < nums.length ; i++) {
            map.put(nums[i], i);
        }

        int ans = 0;

        for(int i=0 ; i<nums.length ; i++ ) {
            if(visited.contains(nums[i])) {
                continue;
            }
            int j=i;
            int cur =0;
            while(j != -1) {
                visited.add(nums[j]);
                cur++;
                ans = Math.max(cur, ans);
                j = map.getOrDefault(nums[j] + 1, -1);
            }
        }
 
        return ans ;
    }
}
