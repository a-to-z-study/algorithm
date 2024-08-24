package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class HallOfFame1 {
	public int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];
		Queue<Integer> pq = new PriorityQueue<>();

		int day = 0;

		for (int nextScore : score) {
			pq.offer(nextScore);
			if (pq.size() > k) {
				pq.poll();
			}
			answer[day] = pq.peek();
			day++;
		}

		return answer;
	}
}
