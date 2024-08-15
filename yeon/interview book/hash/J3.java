package hash;

import java.util.HashMap;
import java.util.Map;

public class J3 {

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> counter = new HashMap<>();

		int left = 0;
		int right = 0;
		int maxLength = 0;

		for (char c : s.toCharArray()) {
			if (counter.containsKey(c) && counter.get(c) >= left) {
				left = counter.get(c) + 1;
			} else {
				maxLength = Math.max(maxLength, right - left + 1);
			}

			counter.put(c, right);
			right++;
		}

		return maxLength;
	}

}
