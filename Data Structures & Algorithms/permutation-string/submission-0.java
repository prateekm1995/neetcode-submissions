class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        int l=0,r=0;
        while(r < s1.length()) {
            map1[s1.charAt(r) - 'a']++;
            map2[s2.charAt(r) - 'a']++;
            r++;
        }

        while(r < s2.length()) {
            if(compare(map1, map2)) {
                return true;
            } else {
                map2[s2.charAt(l) - 'a']--;
                map2[s2.charAt(r) - 'a']++;
                r++;
                l++;
                
            }
        }
        return compare(map1, map2);
                
    }

    private boolean compare(int[] m1, int[] m2) {
        for(int i=0;i<26;i++) {
            if(m1[i] != m2[i])
                return false;
        }
        return true;
    }
}