class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList();
        backtrack(new StringBuilder(), n, n);
        return ans;
    }

    private void backtrack(StringBuilder s, int open, int close){
        if(open == 0 && close == 0){
            ans.add(s.toString());
        }
        if(open > 0){
            s.append("(");
            backtrack(s, open-1, close);
            s.deleteCharAt(s.length()-1);
        }
        if(close > open){
            s.append(")");
            backtrack(s, open, close-1);
            s.deleteCharAt(s.length()-1);
        }
    }
}