class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];
        int count=0;

        sum[0] = nums[0];
        for(int i=1;i<n;i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        for(int r=0;r<n;r++) {
            for(int l=0;l<=r;l++) {
                if(l==0) {
                    if(sum[r] == k){
                        count++;
                    }
                } else {
                    if(sum[r] - sum[l] + nums[l] == k)
                    count++;
                }
            }
        }
        return count;
    }
}