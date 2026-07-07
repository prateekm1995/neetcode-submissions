class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int minus2 = cost[0];
        int minus1 = cost[1];
        for (int i=2 ; i<cost.length ; i++) {
            int temp = Math.min(minus2, minus1) + cost[i];
            minus2 = minus1;
            minus1 = temp;            
        }

        return Math.min(minus1, minus2);
    }
}