package level2;

import java.util.HashMap;
import java.util.Map;

public class SeesawMate {

	public long solution(int[] weights) {

		Map<Long, Long> counter = new HashMap<>();
		for (int weight : weights) {
			counter.put((long)weight, counter.getOrDefault((long)weight, 0L) + 1);
		}

		long answer = 0;

		for (Map.Entry<Long, Long> entry : counter.entrySet()) {
			// 같은 몸무게의 사람과
			answer += entry.getValue() * (entry.getValue() - 1L) / 2;
			// 다른 몸무게의 사람과 4m : 3m
			if (entry.getKey() * 4L % 3L == 0) {
				answer += entry.getValue() * counter.getOrDefault(entry.getKey() * 4L / 3L, 0L);
			}
			// 다른 몸무게의 사람과 4m : 2m
			answer += entry.getValue() * counter.getOrDefault(entry.getKey() * 4L / 2L, 0L);

			// 다른 몸무게의 사람과 3m : 2m
			if (entry.getKey() * 3L % 2L == 0) {
				answer += entry.getValue() * counter.getOrDefault(entry.getKey() * 3L / 2L, 0L);
			}
		}

		return answer;
	}

}
