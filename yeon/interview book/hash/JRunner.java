package hash;

import java.util.HashMap;
import java.util.Map;

public class JRunner {

	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> counter = new HashMap<>();
		for (String p : participant) {
			counter.put(p, counter.getOrDefault(p, 0) + 1);
		}

		for (String c : completion) {
			if (counter.get(c) == 1) {
				counter.remove(c);
			} else {
				counter.put(c, counter.get(c) - 1);
			}
		}

		return counter.keySet().iterator().next();
	}

}
