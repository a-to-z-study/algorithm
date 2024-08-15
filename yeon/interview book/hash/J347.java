package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class J347 {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequency = new HashMap<>();
		for (int num : nums) {
			frequency.put(num, frequency.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for (int key : frequency.keySet()) {
			queue.add(new int[]{key, frequency.get(key)});
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = queue.poll()[0];
		}

		return result;
	}

}
