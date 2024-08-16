package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J621 {

	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> counter = new HashMap<>();

		for (char task : tasks) {
			counter.put(task, counter.getOrDefault(task, 0) + 1);
		}

		int maxValue = Collections.max(counter.values());
		List<Character> maxKeys = new ArrayList<>();

		for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
			if (entry.getValue() == maxValue) {
				maxKeys.add(entry.getKey());
			}
		}

		int minLength;
		if (n + 1 < maxKeys.size()) {
			minLength = maxKeys.size() * maxValue;
		} else {
			minLength = (maxValue - 1) * n + maxValue + maxKeys.size() - 1;
		}

		return Math.max(minLength, tasks.length);
	}

}
