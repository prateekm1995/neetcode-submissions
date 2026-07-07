class Solution {
    public int removeDuplicates(int[] nums) {
        int ans = nums.length;
        int k=0;
        for (int i=1 ; i<ans ; i++) {
            if(nums[i] == nums[i-1]) {
                k++;
            } else {
                if(k!=0) {
                    for(int j = i; j<ans ; j++) {
                        nums[j-k] = nums[j];
                        
                    }
                    ans -= k;
                    i -= k;
                    k=0;
                }
            }
        }
        ans -=k;
        
        return ans;
    }
}