package level2;

import java.util.Arrays;

public class InterceptionSystem {

	public int solution(int[][] targets) {
		Arrays.sort(targets, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});

		int answer = 0;
		int current_end = targets[0][1];

		for (int[] target : targets) {
			if (target[0] < current_end) {
				current_end = Math.min(current_end, target[1]);
				continue;
			}

			answer++;
			current_end = target[1];
		}

		answer++;

		return answer;
	}

}
