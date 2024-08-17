package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class J215 {

	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

		for (int num : nums) {
			heap.add(num);
		}

		for (int i = 0; i < k - 1; i++) {
			heap.poll();
		}

		return heap.poll();
	}

}
