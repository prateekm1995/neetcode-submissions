class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int minus1 = Math.max(nums[0], nums[1]);
        int minus2 = nums[0];
        int ans = Math.max(minus1, minus2);

        for(int i=2 ; i<nums.length ; i++) {
            ans = Math.max(minus1, nums[i] + minus2);
            minus2 = minus1;
            minus1 = ans;
        }

        return minus1; 
    }
}
