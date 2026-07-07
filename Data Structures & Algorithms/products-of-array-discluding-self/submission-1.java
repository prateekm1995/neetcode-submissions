class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        for(int i=0;i<n ; i++){
            if(i == 0 ){
                prefix[i]=1;
                suffix[n-i-1]=1;
            } else {
                prefix[i] = prefix[i-1]*nums[i-1];
                suffix[n-1-i] = suffix[n-i] * nums[n-i];
            }
        }
        int[] res = new int[nums.length];

        for(int i=0;i<n;i++){
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }
}  
