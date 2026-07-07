class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int curLength = 0;
        if(s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();

        int l=0,r=0;
        char[] arr = s.toCharArray();

        while(r < s.length()) {         
                while(set.contains(arr[r])) {
                    set.remove(arr[l]);
                    curLength--;
                    l++;
                }

                set.add(arr[r]);
                curLength++;
                maxLength = Math.max(maxLength, curLength);
                r++;           
        }
        return maxLength;
    }
}