package shortest;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class J743 {

	public int networkDelayTime1(int[][] times, int n, int k) {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		for (int[] time: times) {
			graph.putIfAbsent(time[0], new HashMap<>());
			graph.get(time[0]).put(time[1], time[2]);
		}

		Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());
		queue.add(new AbstractMap.SimpleEntry<>(k, 0));

		Map<Integer, Integer> costs = new HashMap<>();
		while(!queue.isEmpty()) {
			Map.Entry<Integer, Integer> current = queue.poll();
			int node = current.getKey();
			int cost = current.getValue();

			if (!costs.containsKey(node)) {
				costs.put(node, cost);

				if (graph.containsKey(node)) {
					for (Map.Entry<Integer, Integer> child : graph.get(node).entrySet()) {
						int alt = cost + child.getValue();
						queue.add(new AbstractMap.SimpleEntry<>(child.getKey(), alt));
					}
				}
			}
		}

		if (costs.size() == n) {
			return Collections.max(costs.values());
		}

		return -1;
	}

}
