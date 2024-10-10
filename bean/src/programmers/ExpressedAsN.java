package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressedAsN {
	public int solution(int N, int number) {
		int answer = -1;

		if (N == number) {
			return 1;
		}

		List<Set<Integer>> comb = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			comb.add(new HashSet<>());
		}

		comb.get(1).add(N);

		for (int k = 2; k < 9; k++) {
			Set<Integer> combSet = comb.get(k);
			int value = 0;
			for (int i = 0; i < k; i++) {
				value = (value * 10) + N;
			}
			combSet.add(value);

			for (int a = 1; a < k; a++) {
				int b = k - a;
				for (int num1 : comb.get(a)) {
					for (int num2 : comb.get(b)) {
						combSet.add(num1 + num2);
						combSet.add(num1 - num2);
						combSet.add(num1 * num2);
						if (num2 != 0) {
							combSet.add(num1 / num2);
						}
					}
				}
			}

			if (combSet.contains(number)) {
				answer = k;
				break;
			}
		}

		return answer;
	}
}
