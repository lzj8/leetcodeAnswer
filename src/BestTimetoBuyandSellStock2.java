public class BestTimetoBuyandSellStock2 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int len = prices.length;
		int buy = prices[0];
		int max = 0;
		for (int i = 1; i < len; ++i) {
			while (i < len && prices[i] <= prices[i - 1]) {
				++i;
			}
			if (i >= len)
				break;

			buy = prices[i - 1];
			while (i < len && prices[i] >= prices[i - 1]) {
				++i;
			}
			max += (prices[i - 1] - buy);
		}
		return max;
	}
}
