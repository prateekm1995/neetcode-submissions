class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] l = new int[n];
        int[] r = new int[n];

        l[0]=0;
        r[n-1] = 0;
        for(int i=1; i<n;i++) {
            l[i] = l[i-1] + nums[i-1];
            r[n-i-1] = r[n-i] + nums[n-i];
        }
        for(int i=0;i<n;i++) {
            if(l[i] == r[i]){
                return i;
            }
        }
        return -1;
    }
}