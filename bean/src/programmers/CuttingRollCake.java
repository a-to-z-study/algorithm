package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CuttingRollCake {
	public int solution(int[] topping) {
		int answer = 0;
		Set<Integer> a = new HashSet<>();
		Map<Integer, Integer> b = new HashMap<>();

		for (int n : topping) {
			b.put(n, b.getOrDefault(n, 0) + 1);
		}

		for (int n : topping) {
			a.add(n);
			int cnt = b.get(n);
			if (cnt > 1) {
				b.put(n, cnt - 1);
			} else {
				b.remove(n);
			}

			if (a.size() == b.size()) {
				answer++;
			}
		}

		return answer;
	}
}
