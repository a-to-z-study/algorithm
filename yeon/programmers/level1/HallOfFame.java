package level1;

import java.util.PriorityQueue;
import java.util.Queue;

public class HallOfFame {

	public int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];

		Queue<Integer> priorityQueue = new PriorityQueue<>();

		for (int i = 0; i < score.length; i++) {
			priorityQueue.add(score[i]);

			if (priorityQueue.size() > k) {
				priorityQueue.poll();
			}

			answer[i] = priorityQueue.peek();
		}

		return answer;
	}

}
