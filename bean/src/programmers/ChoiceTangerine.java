package programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChoiceTangerine {
	public int solution(int k, int[] tangerine) {
		int answer = 0;

		// 귤이 많은 순으로
		Map<Integer, Integer> map = new HashMap<>();

		for (int t : tangerine) {
			map.put(t, map.getOrDefault(t, 0) + 1);
		}

		List<Integer> sorted = map.entrySet()
			.stream()
			.map(Map.Entry::getValue)
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.toList());

		for (int n : sorted) {
			if (k <= 0) {
				break;
			}
			k -= n;
			answer++;
		}

		return answer;
	}
}
