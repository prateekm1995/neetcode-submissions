class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(Character c : s.toCharArray()) {
            if(c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }
            else {
                if(c == '}'&& (stack.isEmpty() || stack.pop() != '{')){
                        return false;
                }
                if(c == ')'&& (stack.isEmpty() || stack.pop() != '(')){
                        return false;
                }
                if(c == ']'&& (stack.isEmpty() || stack.pop() != '[')){
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}