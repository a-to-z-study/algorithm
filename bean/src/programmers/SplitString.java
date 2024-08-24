package programmers;

public class SplitString {
	public int solution(String s) {
		int answer = 0;
		int sameCount = 0;
		boolean isNew = true;
		char x = 'a';

		for (int i = 0; i < s.length(); i++) {
			if (isNew) {
				sameCount = 1;
				x = s.charAt(i);
				isNew = false;
				continue;
			}

			if (x == s.charAt(i)) {
				sameCount++;
			} else {
				sameCount--;
			}

			if (sameCount == 0) {
				isNew = true;
				answer++;
			}
		}

		if (sameCount != 0) { answer++; }

		return answer;
	}
}
