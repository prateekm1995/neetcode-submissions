class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int answer = Integer.MIN_VALUE;
        while (l < r) {
            answer = Math.max(answer, Math.min(height[l], height[r])*(r-l));
            if(height[l] < height[r]){
                l++;
            }else {
                r--;
            }

        }
        return answer;
    }
}