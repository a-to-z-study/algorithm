package level1;

public class PaintOver {

	public int solution(int n, int m, int[] section) {
		if (m == 1) {
			return section.length;
		}

		int answer = 0;
		int current = 0;

		for (int s : section) {
			if (current < s) {
				answer++;
				current = s + m - 1;
			}
		}

		return answer;
	}

}
