package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CardDivision {
	public int solution(int[] arrayA, int[] arrayB) {
		PriorityQueue<Integer> aQ = findDivisionNumbers(arrayA);
		PriorityQueue<Integer> bQ = findDivisionNumbers(arrayB);

		int numberA = 0;
		while (!aQ.isEmpty()) {
			int divideNumber = aQ.poll();

			if (!isAnyDivided(arrayB, divideNumber)) {
				numberA = divideNumber;
				break;
			}
		}

		while (!bQ.isEmpty()) {
			int divideNumber = bQ.poll();

			if (!isAnyDivided(arrayA, divideNumber)) {
				numberA = Math.max(numberA, divideNumber);
				break;
			}
		}

		return numberA;
	}

	private PriorityQueue<Integer> findDivisionNumbers(int[] array) {
		Arrays.sort(array);
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n2, n1));
		if (array.length == 1) {
			pq.add(array[0]);
			return pq;
		}

		int max = array[array.length - 1] / 2;

		for (int i = 2; i <= max; i++) {
			if (isAllDivided(array, i)) {
				pq.offer(i);
			}
		}

		return pq;
	}

	private boolean isAllDivided(int[] array, int divideNumber) {
		for (int n : array) {
			if (n % divideNumber != 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isAnyDivided(int[] array, int divideNumber) {
		for (int n : array) {
			if (n % divideNumber == 0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		final int solution = new CardDivision().solution(new int[] {5}, new int[] {8});
		System.out.println(solution);
	}
}
