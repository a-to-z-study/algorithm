package greedy;

public class J122 {

	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int buy = prices[0];

		for (int price: prices) {
			if (price < buy) {
				buy = price;
			} else if (price > buy) {
				maxProfit += price - buy;
				buy = price;
			}
		}

		return maxProfit;
	}

}
