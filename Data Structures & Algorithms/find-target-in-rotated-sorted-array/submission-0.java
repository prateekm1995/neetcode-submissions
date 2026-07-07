class Solution {
    public int search(int[] nums, int target) {
        int l=0, r = nums.length-1;
        while(l < r) {
            int mid = (l + r)/2;
            if(nums[mid] > nums[r]) {
                l = mid +1;
            } else {
                r= mid;
            }
        }
        if( l == 0) {
            return search(nums, target, 0, nums.length-1);
        } else if(target >= nums[0]) {
            return search(nums, target, 0, l-1);
        } else {
            return search(nums, target, l, nums.length-1);
        }
    }

    private int search(int[] nums, int target, int l, int r) {
        if(l > r) {
            return -1;
        }
        int mid = l + (r-l)/2;
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] > target) {
            return search(nums, target, l, mid-1);
        } else {
            return search(nums, target, mid+1,r);
        }
    }
}
