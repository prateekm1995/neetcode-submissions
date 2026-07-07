class Solution {
    public boolean validPalindrome(String s) {
        
        int last = s.length()-1;
        for(int i=0; i<last ; i++) {
            if(s.charAt(i) != s.charAt(last-i)) {
                return checkPalindrome(s.substring(0,i) + s.substring(i+1, last+1)) || checkPalindrome(s.substring(0, last-i) + s.substring(last-i+1, last+1));
            }
        }
        return true;
    }

    boolean checkPalindrome(String s) {
        int last = s.length()-1;
        for(int i=0; i<last ; i++) {
            if(s.charAt(i) != s.charAt(last-i)) {
                return false;
            }
        }
        return true;
    }
    
}