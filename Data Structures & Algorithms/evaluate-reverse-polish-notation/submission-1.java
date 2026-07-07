class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Integer result=0;
         for(int i=0; i< tokens.length; i++) {
             if(tokens[i].equals("+")){
                Integer rhs = stack.pop();
                Integer lhs = stack.pop();
                result = lhs+rhs;
                stack.push(result);
             } else if(tokens[i].equals("-")){
                Integer rhs = stack.pop();
                Integer lhs = stack.pop();
                result = lhs-rhs;
                stack.push(result);
             } else if(tokens[i].equals("/")){
                Integer rhs = stack.pop();
                Integer lhs = stack.pop();
                result = lhs/rhs;
                stack.push(result);
             } else if(tokens[i].equals("*")){
                Integer rhs = stack.pop();
                Integer lhs = stack.pop();
                result = lhs*rhs;
                stack.push(result);
             } else {
                System.out.println(tokens[i] + "here");
                stack.push(Integer.valueOf(tokens[i]));
             }
         }
         return stack.pop();
    }
}
