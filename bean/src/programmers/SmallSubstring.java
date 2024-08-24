package programmers;

public class SmallSubstring {
	public int solution(String t, String p) {
		int answer = 0;
		int n = p.length();

		int len = t.length();
		boolean equals;
		for (int start = 0; start + n <= len; start++) {
			equals = true;
			for (int i = 0; i < n; i++) {
				if (p.charAt(i) == t.charAt(start + i)) {
					continue;
				}
				if (p.charAt(i) < t.charAt(start + i)) {
					equals = false;
				}
				break;
			}
			if (equals) {
				answer++;
			}
		}

		return answer;
	}
}
