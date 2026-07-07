class Solution {
    Map<Character, String> map;
    public Solution() {
    map = new HashMap();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList();
        dfs(digits, "", ans);
        return ans;
    }

    private void dfs(String digits, String curWord, List<String> ans){
        if(digits.isEmpty()){
            if(!curWord.isEmpty()){
                ans.add(curWord);
            }
            return;
        }

        char digit = digits.charAt(0);

        for(char c : map.get(digit).toCharArray()) {
            dfs(digits.substring(1), curWord + c, ans);
        }
    }
}
