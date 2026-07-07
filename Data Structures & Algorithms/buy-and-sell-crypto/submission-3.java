class Solution {
    public int maxProfit(int[] prices) {
        int b=0,s=1;
        int max=0;

        while(s < prices.length) {
            if(prices[s] < prices[b]) {
                b=s;
            } else {

            max = Math.max(prices[s] - prices[b], max);
            }
            s++;
        }

        return max;
    }
}
