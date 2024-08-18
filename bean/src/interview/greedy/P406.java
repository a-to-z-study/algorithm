package interview.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P406 {
	public int[][] reconstructQueue(int[][] people) {

		Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0]) {
				return b[0] - a[0];
			}
			return a[1] - b[1];
		});

		for (int[] p : people) {
			pq.offer(p);
		}

		List<int[]> answer = new ArrayList<>();
		while (!pq.isEmpty()) {
			int[] person = pq.poll();
			answer.add(person[1], person);
		}
		return answer.toArray(new int[][]{});
	}

	public static void main(String[] args) {
		new P406().reconstructQueue(new int[][] {
			{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}
		);
	}
}
