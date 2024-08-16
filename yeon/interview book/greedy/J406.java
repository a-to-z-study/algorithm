package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class J406 {

	public int[][] reconstructQueue(int[][] people) {
		Queue<int []> queue = new PriorityQueue<>(
			(a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]
		);

		for (int[] person: people) {
			queue.add(person);
		}

		List<int[]> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int[] person = queue.poll();
			result.add(person[1], person);
		}

		return result.toArray(new int[people.length][2]);
	}

}
