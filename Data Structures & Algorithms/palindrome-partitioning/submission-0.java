class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList();
        dfs(s, new ArrayList());
        return ans;
    }

    private void dfs(String s, List<String> cur){
        if(s.isEmpty()){
            ans.add(new ArrayList(cur));
            return;
        }

        for(int i=0 ; i<s.length();i++){
            String pal = s.substring(0,i+1);
            if(isPal(pal)){
                cur.add(pal);
                dfs(s.substring(i+1), cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPal(String s){
        int n = s.length();
        for(int i=0 ; i<n; i++){
            if( s.charAt(i) != s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    } 
}
