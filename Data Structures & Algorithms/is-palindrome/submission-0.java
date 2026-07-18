class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int j = s.length() - 1;
        int i=0;
        while(i < j) {
            if(!isAlphanumeric(s.charAt(i))) {
                i++;
            } else if (!isAlphanumeric(s.charAt(j))) {
                j--;
            } else {
                if( s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isAlphanumeric(char a) {
        return (a >= 'a' && a <= 'z') ||
                (a >='0' && a <= '9');
    }
}