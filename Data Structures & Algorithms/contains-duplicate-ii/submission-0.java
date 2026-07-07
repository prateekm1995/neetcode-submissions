class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int j=1; j<=k ; j++) {
            for(int i=0; i<nums.length-j ; i++) {
                if(nums[i] == nums[i+j]) {
                    return true;
                }
            }
        }
        return false;
    }
}