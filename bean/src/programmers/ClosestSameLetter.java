package programmers;

import java.util.HashMap;
import java.util.Map;

public class ClosestSameLetter {
	public int[] solution(String s) {
		Map<Character, Integer> record = new HashMap<>();
		int[] answer = new int[s.length()];
		char[] alphabets = s.toCharArray();

		for (int i = 0; i < alphabets.length; i++) {
			char alphabet = alphabets[i];
			if (record.containsKey(alphabet)) {
				answer[i] = i - record.get(alphabet);
			} else {
				answer[i] = -1;
			}
			record.put(alphabet, i);
		}

		return answer;
	}
}
