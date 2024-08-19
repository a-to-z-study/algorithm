package interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		// strs = ["eat","tea","tan","ate","nat","bat"]

		// abc순 정렬로 바꾸면
		Map<String, List<String>> answer = new HashMap<>();
		for (String str : strs) {

			// 매우 느림 Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);

			if (!answer.containsKey(key)) {
				answer.put(key, new ArrayList<>());
			}
			answer.get(key).add(str);
		}

		return new ArrayList<>(answer.values());
	}
}
