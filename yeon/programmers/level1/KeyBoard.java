package level1;

import java.util.HashMap;
import java.util.Map;

public class KeyBoard {

	public int[] solution(String[] keymap, String[] targets) {
		Map<Character, Integer> dict = new HashMap<>();

		for (String key : keymap) {
			for (int i = 0; i < key.length(); i++) {
				dict.put(key.charAt(i), Math.min(dict.getOrDefault(key.charAt(i), 100), i + 1));
			}
		}

		int[] answer = new int[targets.length];

		for (int s = 0; s < targets.length; s++) {
			String target = targets[s];
			int count = 0;
			boolean impossible = false;

			for (int i = 0; i < target.length(); i++) {
				if (!dict.containsKey(target.charAt(i))) {
					impossible = true;
					break;
				}

				count += dict.get(target.charAt(i));
			}

			if (impossible) {
				answer[s] = -1;
			} else {
				answer[s] = count;
			}
		}

		return answer;
	}

}
