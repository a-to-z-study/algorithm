package level1;

public class SmallSubstring {

	public int solution(String t, String p) {
		long p_number = Long.parseLong(p);
		int answer = 0;

		for (int i = 0; i < t.length() - p.length() + 1; i++) {
			if (Long.parseLong(t.substring(i, i + p.length())) <= p_number) {
				answer++;
			}
		}

		return answer;
	}

}
