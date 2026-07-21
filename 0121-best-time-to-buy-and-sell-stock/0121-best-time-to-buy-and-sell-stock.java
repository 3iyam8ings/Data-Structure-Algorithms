class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0] ;
        int max_profit = 0;
        int n = prices.length;

        for(int i=1;i<n;i++){
            int cost = prices[i] - mini;
            max_profit = Math.max(max_profit, cost);
            mini = Math.min( mini, prices[i]);
        }
        return max_profit;
    }
}