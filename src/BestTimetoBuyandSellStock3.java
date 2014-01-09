public class BestTimetoBuyandSellStock3 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int len = prices.length;
		int[] max1 = new int[len];
		int[] max2 = new int[len];
		max1[0] = 0;
		int min = prices[0];
		for (int i = 1; i < len; ++i) {
			max1[i] = Math.max(max1[i - 1], prices[i] - min);
			min = Math.min(prices[i], min);
		}
		max2[len - 1] = 0;
		int max = prices[len - 1];
		for (int i = len - 2; i >= 0; --i) {
			max2[i] = Math.max(max2[i + 1], max - prices[i]);
			max = Math.max(prices[i], max);
		}

		int profit = max1[len - 1];
		for (int i = 1; i < len; ++i) {
			profit = Math.max(profit, max1[i - 1] + max2[i]);
		}
		return profit;
	}

	public static void main(String[] args) {

	}
}
