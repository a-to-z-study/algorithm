package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J49 {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> dictionary = new HashMap<>();

		for (String word : strs) {
			char[] charArray = word.toCharArray();
			Arrays.sort(charArray);
			String key = String.valueOf(charArray);

			if (!dictionary.containsKey(key)) {
				dictionary.put(key, new ArrayList<>());
			}

			dictionary.get(key).add(word);
		}

		return new ArrayList<>(dictionary.values());
	}

}
