package level2;

public class IntegerPair {

	/**
	 * 중심이 (a, b)인 원의 방적식 : (x - a)^2 + (y - b)^2 = r^2
	 * 원의 중심이 (0, 0)이면 x^2 + y^2 = r^2 으로 단순화할 수 있다.
	 * 예를 들어 반지름이 5이고 x좌표가 3인 경우 y좌표는 9 + y^2 = 25, y^2 = 25 - 9, y^2 = 16, y = 4가 된다.
	 */
	public long solution(int r1, int r2) {
		long answer = 0;

		for (int i = 1; i <= r2 ; i++){
			double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
			double y1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
			answer += ((long)y2 - (long)Math.ceil(y1) + 1);
		}

		answer *= 4;

		return answer;
	}

}
