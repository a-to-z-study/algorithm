package level1;

import java.util.HashMap;
import java.util.Map;

public class ClosestSameLetter {

	public int[] solution(String s) {
		int[] answer = new int[s.length()];
		Map<Character, Integer> closest_index = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char alpha = s.charAt(i);
			int index = closest_index.getOrDefault(alpha, -1);

			if (index < 0) {
				answer[i] = index;
			} else {
				answer[i] = i - index;
			}

			closest_index.put(alpha, i);
		}

		return answer;
	}

}
