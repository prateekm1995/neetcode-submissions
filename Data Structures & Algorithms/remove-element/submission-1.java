class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int i=0;
        for (int j=0 ; j<nums.length ; j++) {
            if(nums[i] != val) {
                i++;
            } else {
                if(nums[j] != val) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
            }
        }
        return i;
    }
}