package programmers;

public class SumOfConsecutiveSubsequences {
	public int[] solution(int[] sequence, int k) {
		int[] answer = new int[2];

		int len = sequence.length - 1;
		int sum = sequence[0];
		int lt = 0;
		int rt = 0;
		int windowSize = Integer.MAX_VALUE;

		while (lt <= len) {
			if (sum < k && rt < len) {
				rt++;
				sum += sequence[rt];
				continue;
			}

			if (sum == k && rt - lt < windowSize) {
				windowSize = rt - lt;
				answer[0] = lt;
				answer[1] = rt;
			}

			sum -= sequence[lt];
			lt++;
		}

		return answer;
	}
}
