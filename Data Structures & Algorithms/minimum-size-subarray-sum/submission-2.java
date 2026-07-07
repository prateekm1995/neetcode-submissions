class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,sum=0,ans=Integer.MAX_VALUE;
        while(r < nums.length && l <= r) {
            if( sum < target){
                sum+=nums[r++];
            } else {
                 ans = Math.min(ans, r-l);
                 sum -= nums[l++];
            }
        }
        while(sum >= target) {
            ans = Math.min(ans, r-l);
            sum -= nums[l++];
        }
        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}