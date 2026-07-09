

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<n ; i++){
            if(stack.isEmpty()){
                stack.push(i);
            }else {
                while(!stack.isEmpty() 
                        && temperatures[stack.peek()] < temperatures[i]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;

        

    }
}
