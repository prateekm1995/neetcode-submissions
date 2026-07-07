class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int curMostFreq = -1 ;
        char[] arr = s.toCharArray();
        int l=0, r=0;
        while(r < s.length()) {
            map[arr[r] - 'A']++;
            if( curMostFreq == -1) 
            {
                curMostFreq = arr[r] - 'A';
            } else {
                if(map[curMostFreq ] < map[arr[r] - 'A']) {
                    curMostFreq = arr[r] - 'A';
                }
            }

            if( Arrays.stream(map).sum() - map[curMostFreq] > k) {
                map[arr[l] - 'A']--;
                l++;
            }
            r++;
        }
        return r-l;


    }

    
}
