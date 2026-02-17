package basic.algorithm.leetcode;

public class leetCode_121_bestTimeToBuyAndSellStock_greedy {

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;

        //3 5 2 1

        for(int i=0; i<prices.length; i++) {
            int price = prices[i];
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }

        return maxProfit;
    }
}
