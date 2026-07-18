class Solution {
    public int maxArea(int[] heights) {
        int l=0, r = heights.length-1;
        int ans = 0;
        while (l < r) {
            int cur = Math.min(heights[l], heights[r]) * (r-l);
            ans = Math.max(ans, cur);

            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans ;
    }
}
