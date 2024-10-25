package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DefenceGame {
	public int solution(int n, int k, int[] enemy) {
		Queue<Integer> record = new PriorityQueue<>(Comparator.reverseOrder());

		int round = 0;
		for (int i = 0; i < enemy.length; i++) {
			// 현재 적이 더 많으면
			if (n < enemy[i]) {
				// 무적권을 쓴다
				if (--k < 0) {
					// 무적권 다 쓰면 break
					break;
				}

				if (record.isEmpty() || record.peek() < enemy[i]) {
					round++;
					continue;
				}

				n += record.poll();
			}

			n -= enemy[i];
			record.add(enemy[i]);
			round++;
		}

		return round;
	}
}
