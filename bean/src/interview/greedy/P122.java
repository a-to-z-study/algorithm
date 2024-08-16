package interview.greedy;

public class P122 {
	public int maxProfit(int[] prices) {
		int totalProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i] < prices[i + 1]) {
				int profit = prices[i + 1] - prices[i];
				totalProfit += profit;
			}
		}

		return totalProfit;
	}

	public static void main(String[] args) {
		System.out.println(new P122().maxProfit(new int[] {2,1,2,0,1}));
	}
}
