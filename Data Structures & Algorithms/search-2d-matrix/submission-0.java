class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, t=0, b = m-1;

        while(t <= b) {
            int mid = (t+b)/2;
            if(target == matrix[mid][0] || target == matrix[mid][n-1]) {
                return true;
            } else if(target > matrix[mid][0] && target < matrix[mid][n-1]) {
                return search(matrix[mid], target);
            } else if(target < matrix[mid][0]) {
                b = mid-1;
            } else {
                t = mid +1;
            }
        }
        return false;

        
        
    }

    private boolean search(int[] nums, int target) {
        int l=0, r = nums.length-1;

        while(l <= r) {
            int mid  = l + (r-l)/2;
            if(nums[mid] == target){
                return true;
            } else if( nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return false;
    }
}
