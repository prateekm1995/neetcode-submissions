class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        memo[0]=0;

        for(int i=1 ; i <= amount; i++){
            memo[i] = Integer.MAX_VALUE-1;
            for(int c : coins) {
                if(i - c >= 0) {
                    memo[i] = Math.min(memo[i], 1+memo[i-c]);
                }
            }
        }

        return memo[amount] == Integer.MAX_VALUE-1 ? -1 : memo[amount];
    }
}
