class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;

        while(sell < prices.length){
            if(prices[sell] < prices[buy]){
                buy++;
            }
            else if(prices[sell] - prices[buy] > maxProfit){
                maxProfit = prices[sell] - prices[buy];
            }
            else{
                sell++;
            }

        }
        return maxProfit;
    }
}
