class Solution {
    List<List<Integer>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList();
        dfs(new ArrayList(), n);
        return ffinal();        
    }

    private void dfs(List<Integer> queen, int n){
        if(queen.size() == n){
            ans.add(new ArrayList(queen));
            return;
        }

        for(int i=0;i<n;i++){

            if(isSafe(queen, i)){
                queen.add(i);
                dfs(queen,n);
                queen.remove(queen.size()-1);
            }
        }
    }

    private boolean isSafe(List<Integer> queen, int i){
        for(int j=0;j < queen.size() ; j++){
            if( i == queen.get(j) ||
                (Math.abs(queen.get(j) - i) == Math.abs(j - queen.size()))
                ){
                    return false;
            }
        }
        return true;
    }

    private List<List<String>> ffinal(){
        List<List<String>> res = new ArrayList();
        for(List<Integer> a : ans){
            List<String> cur = new ArrayList();
            for(int i=0; i<a.size();i++){
                String s = new String();
                for(int j=0 ; j<a.size();j++){
                    if(j == a.get(i)){
                        s += 'Q';
                    } else {
                        s += '.';
                    } 
                }
                cur.add(s);
            }
            res.add(cur);
        }
        return res;
    }
}
