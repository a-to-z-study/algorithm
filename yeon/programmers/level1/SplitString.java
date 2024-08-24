package level1;

public class SplitString {

	public int solution(String s) {
		if (s.length() == 1) {
			return 1;
		}

		int answer = 0;

		char x = s.charAt(0);
		int x_count = 1;
		int not_x_count = 0;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == x) {
				x_count++;
			} else {
				not_x_count++;
			}

			if (x_count == not_x_count || i == s.length() - 1) {
				answer++;

				if (i + 1 < s.length()) {
					x = s.charAt(i + 1);
					x_count = 0;
					not_x_count = 0;
				}
			}
		}

		return answer;
	}

}
