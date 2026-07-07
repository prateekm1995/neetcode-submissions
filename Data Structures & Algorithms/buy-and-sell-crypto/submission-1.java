class Solution {
    public int maxProfit(int[] prices) {
        int l=0,r=1;
        int max = Integer.MIN_VALUE;
        int cur=0;
        while(r < prices.length){
            if(prices[r] < prices[l]){
                max = Math.max(max, cur);
                cur = 0;
                l=r;
                r++;
            } else {
                cur = Math.max(cur, prices[r] - prices[l]);
                r++;
            }
        }
        max = Math.max(max, cur);
        return max;
    }
}
