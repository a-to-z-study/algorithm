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
			// 같은 몸무게의 사람이 마주보고 앉는 경우 : 같은 거리의 좌석에 앉으면 된다
        	// nC2 = n! / 2!(n-2)!
        	// 같은 몸무게의 사람 수 * 나 자신을 제외하고 같은 몸무게를 가진 사람의 수 / 2
			answer += entry.getValue() * (entry.getValue() - 1L) / 2;

			// 서로 다른 몸무게의 두 사람이 마주보고 앉는 경우 : 다른 거리의 좌석에 앉아야 한다
			// 1) 4m & 3m
			// 몸무게 A * 4m = 몸무게 B * 3m
			// 몸무게 B = 몸무게 A * 4m / 3m
			if (entry.getKey() * 4L % 3L == 0) {
				answer += entry.getValue() * counter.getOrDefault(entry.getKey() * 4L / 3L, 0L);
			}
        	// 2) 4m & 2m
        	// 몸무게 A * 4m = 몸무게 B * 2m
        	// 몸무게 B = 몸무게 A * 4m / 2m
			answer += entry.getValue() * counter.getOrDefault(entry.getKey() * 4L / 2L, 0L);

			// 3) 3m & 2m
        	// 몸무게 A * 3m = 몸무게 B * 2m
        	// 몸무게 B = 몸무게 A * 3m / 2m
			if (entry.getKey() * 3L % 2L == 0) {
				answer += entry.getValue() * counter.getOrDefault(entry.getKey() * 3L / 2L, 0L);
			}
		}

		return answer;
	}

}
