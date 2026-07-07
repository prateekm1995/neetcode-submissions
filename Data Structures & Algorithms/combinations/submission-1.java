class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
            ans = new ArrayList();
            backtrack(n,k,new ArrayList());

            return ans;        
    }

    private void backtrack(int n, int k, List<Integer> cur){
        if(cur.size() == k){
            ans.add(new ArrayList(cur));
            return;
        }

        if( n < k-cur.size()){
            return;
        }
        cur.add(n);
        backtrack(n-1,k, cur);
        cur.remove(cur.size()-1);
        backtrack(n-1,k, cur);
    }
}