class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0 ;
        int[] map = new int[26];
        int l=0, r=0;
        int max=-1;

        while (r < s.length()) {
            // expand window
            map[s.charAt(r) - 'A']++;
            if(max == -1 || map[max] < map[s.charAt(r) - 'A']) {
                max = s.charAt(r) - 'A';
            }
            int cur = r-l+1;
            if(r-l+1 - map[max] <= k){
                ans = Math.max(ans, r-l+1);
            }
            // voilation, contract window
            while(r-l+1 - map[max] > k) {
                map[s.charAt(l) - 'A']--;
                l++;
                // update max;
                if(2*map[max] < r-l+1){
                    max = findMax(map);
                }
                
            }
            r++;
        }
       
        return ans;
    }

    private int findMax(int[] map) {
         int max = -1;
        for(int i=0 ; i< map.length ; i++){
            if (max == -1 || map[i] > map[max]) {
                max = i;
            }
        }
        return max;
    }
}
