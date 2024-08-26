package level1;

public class KnightsWeapon {

	public int solution(int number, int limit, int power) {
		int answer = 0;
		int[] divisors = new int[number + 1];

		for (int i = 1; i <= number; i++) {  // 1부터 number까지
			for (int j = i; j <= number; j += i) {  // i의 배수만큼 돈다 ex) i = 3: 3, 6, 9, 12, 15...
				divisors[j]++;
			}

			if (divisors[i] > limit) {
				answer += power;
			} else {
				answer += divisors[i];
			}
		}

		return answer;
	}

}
