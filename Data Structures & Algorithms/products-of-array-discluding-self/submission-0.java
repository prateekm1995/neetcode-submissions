class Solution {
    public int[] productExceptSelf(int[] nums) {
        int last = nums.length-1;
        int[] pl= new int[nums.length];
        int[] pr= new int[nums.length];
        int[] res= new int[nums.length];
        for(int i=0; i< nums.length ; i++) {
            if(i==0) {
                pl[0] = 1;
                pr[last] =1;
            }else {
            pl[i] = nums[i-1]*pl[i-1];
            pr[last - i ] = nums[last-i+1]*pr[last-i+1];
            }
        }
        for(int i=0; i< nums.length ; i++) {
            res[i] = pl[i]*pr[i];
        }
        return res;
    }
}  
