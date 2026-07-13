class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque();
        
        for(String c : tokens){
            if("+".equals(c)|| "-".equals(c)|| "*".equals(c)|| "/".equals(c)){
                Integer r = stack.pop(), l = stack.pop();
                
                if("+".equals(c)) {
                    stack.push(l+r);
                } else if("-".equals(c)) {
                    stack.push(l-r);
                } else if("*".equals(c)) {
                    stack.push(l*r);
                } else if("/".equals(c)) {
                    stack.push(l/r);
                } 
            } else {
                stack.push(Integer.valueOf(c));
            }
        }
        return stack.pop();
    }
}