class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];

        for( char c : s.toCharArray()) {
            map[c-'a'] += 1;
        }

        for( char c : t.toCharArray()) {
            map[c-'a'] -= 1;
        }

        for( int x : map) {
            if(x != 0)
                return false;
        }
        return true;
    }
}
