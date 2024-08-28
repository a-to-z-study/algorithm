package level2;

public class SumOfConsecutiveSubsequences {

	public int[] solution(int[] sequence, int k) {
		// 누적합
		int[] sum_list = new int[sequence.length + 1];
		sum_list[0] = 0;

		for (int i = 1; i <= sequence.length; i++) {
			sum_list[i] = sum_list[i - 1] + sequence[i - 1];
		}

		// 투 포인터
		int[] answer = {0, 0};
		int start = 0;
		int end = 0;
		int min_length = 2_000_000;

		while (start <= end && end <= sequence.length) {
			int sum = sum_list[end] - sum_list[start];
			int length = end - start + 1;

			if (sum == k && length < min_length) {
				min_length = length;
				answer[0] = start;
				answer[1] = end - 1;
			}

			if (sum < k) {
				end++;
			} else {
				start++;
			}
		}

		return answer;
	}

}
