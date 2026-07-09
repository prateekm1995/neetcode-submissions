class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
                min = Integer.MAX_VALUE;
            for (int j=i;j<n;j++){
                min = Math.min(min, heights[j]);
                ans = Math.max(ans, (j-i+1)*min);
            }
        }
        return ans;
    }
    
}
