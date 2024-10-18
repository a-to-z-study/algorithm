package level2;

public class DeliveryAndPickup {

	private int d = 0;
	private int p = 0;
	private long answer = 0;

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		for (int i = n - 1; i >= 0; i--) {
			long count = 0;  // 해당 집에 몇 번 방문했는지 count

			d -= deliveries[i];
			p -= pickups[i];

			while (d < 0 || p < 0) {
				d += cap;
				p += cap;
				count++;
			}

			answer += (i + 1) * 2 * count;
		}

		return answer;
	}

}
