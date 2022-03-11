class Solution {
   public int maxProfit(int[] prices) {
		int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);//taking max as -ve's min is max (we want to buy at as max as possible)
		    sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);//now taking max as now buy2 has our 1st trans.'s profit included
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}
}