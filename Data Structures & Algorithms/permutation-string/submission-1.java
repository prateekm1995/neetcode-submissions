class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] target = new int[26];
        int[] tracker = new int[26];

        for (char c : s1.toCharArray()) {
            target[c -'a']++;
        }
        int l = 0, r = 0;

        while (r < s1.length()) {
            tracker[s2.charAt(r) - 'a']++;
            r++;
        }

        if (compare(tracker, target)) {
            return true;
        }

        while (r < s2.length()) {
            tracker[s2.charAt(l) - 'a']--;
            tracker[s2.charAt(r) - 'a']++;
            r++;
            l++;

            if (compare(tracker, target)) {
                return true;
            }
        }
        return false;
    }
    private boolean compare(int[] tracker, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (tracker[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}