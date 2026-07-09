class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        //calculate next smaller tower of each tower
        Deque<Integer> stack = new ArrayDeque<>();
        Integer[] next = new Integer[heights.length];
        Arrays.fill(next, heights.length);
        for(int i=0 ; i<n ; i++){
            while(!stack.isEmpty()
                    && heights[i] < heights[stack.peek()]){
                        int j = stack.pop();
                        next[j] = i;
                    }
            stack.push(i);
        }

        //calculate prev smaller tower of each tower
         stack = new ArrayDeque<>();
        Integer[] prev = new Integer[heights.length];
        Arrays.fill(prev, -1);
        for(int i=n-1 ; i>=0 ; i--){
            while(!stack.isEmpty()
                    && heights[i] < heights[stack.peek()]){
                        int j = stack.pop();
                        prev[j] = i;
                    }
            stack.push(i);
        }
        // calculate max possible width of each height. = h * ( n-p -1)
        int ans = 0;
        for(int i=0; i<n ; i++){
            
            ans = Math.max(ans, heights[i] * (next[i] - prev[i] -1));
        }      
        return ans;  
    }
}
