package level2;

public class MagicElevator {

	public int solution(int storey) {
		int answer = 0;

		while (storey > 0) {
			int moves = storey % 10;
			storey = storey / 10;

			if (moves > 5 || (moves == 5 && storey % 10 >= 5)) {
				moves = 10 - moves;
				storey++;
			}

			answer += moves;
		}

		return answer;
	}

}
