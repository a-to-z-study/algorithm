package programmers;

import java.util.ArrayDeque;

public class ParcelBox {
	public int solution(int[] order) {
		int answer = 0;

		final ArrayDeque<Integer> subQ = new ArrayDeque<>();

		int i = 1;

		for (int n : order) {
			while (i <= n) {
				subQ.addFirst(i++);
			}

			if (!subQ.isEmpty() && subQ.pollFirst() != n) {
				break;
			}
			answer++;
		}

		return answer;
	}
}
