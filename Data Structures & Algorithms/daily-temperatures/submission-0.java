class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<temp.length;i++) {
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()] ) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
    return res;
    }
}
