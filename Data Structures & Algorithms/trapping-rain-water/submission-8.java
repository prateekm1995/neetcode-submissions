class Solution {
    public int trap(int[] height) {
        /* 
        */
        int n= height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        int ans = 0;
        for(int i=0 ; i < n ; i++) {
            if(i==0) {
                leftMax[i] = 0;
                rightMax[n-i-1] = 0;
            } else {
                leftMax[i] = Math.max(leftMax[i-1] , height[i-1]);
                rightMax[n-1 - i] = Math.max(rightMax[n-i], height[n-i]);
            }
        }
        for (int i=0 ; i < n ; i++ ) {
            int minH = Math.min(leftMax[i], rightMax[i]);
            int water = Math.max(minH - height[i], 0);
            ans += water;
        }

        return ans;
    }
}
