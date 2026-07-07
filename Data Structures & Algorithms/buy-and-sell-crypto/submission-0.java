class Solution {
    public int maxProfit(int[] prices) {
        int l=0, r=0, max=0, cur=0;

        while(r < prices.length) {
            if(prices[r] <= prices[l]) {
                max = Math.max(max, cur);
                cur=0;
                l=r;
            } else {
                if(cur < prices[r] - prices[l]) {
                    cur = prices[r] - prices[l];
                    max = Math.max(max, cur);
                }
            }
            r++;
        }
        return max;
    }
}