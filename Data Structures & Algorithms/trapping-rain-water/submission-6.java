class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        lmax[0] = 0;
        rmax[n-1] = 0;
        int ans=0;
        for(int i=1 ; i< n ; i++) {
            lmax[i] = Math.max(lmax[i-1], height[i-1]);
            rmax[n-i-1] = Math.max(rmax[n-i], height[n-i]);
        }
        for(int i=0 ; i< n ; i++) {
            ans += Math.max(Math.min(lmax[i], rmax[i]) - height[i],0);
        }

        
        return ans;
    }
}
