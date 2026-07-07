class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = max(piles);
        int l = 1;
        int mid, k = r;

        while(l <= r) {
            mid = (l + r)/2;
            int time = time(piles, mid);
            if(time <= h) {
                k = Math.min(k, mid);
                r = mid-1;
            } else {
                l = mid + 1;
            }

        }

        return k;
        
    }

    private int max(int[] piles) {
        int max = Integer.MIN_VALUE;
        for(int pile : piles){
            max = max > pile ? max : pile;
        }
        return max;
    }

    private int time(int[] piles, int k) {
        int ans = 0;
        for(int pile : piles) {
            if( pile % k == 0){
                ans += pile/k;
            } else {
                ans += (pile/k) + 1;
            }
        }
        return ans;
    }
}
