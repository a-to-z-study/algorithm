package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J17 {

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();

		if (digits.length() == 0) {
			return result;
		}

		Map<Character, List<Character>> dictionary = new HashMap<>();
		dictionary.put('0', List.of());
		dictionary.put('1', List.of());
		dictionary.put('2', List.of('a', 'b', 'c'));
		dictionary.put('3', List.of('d', 'e', 'f'));
		dictionary.put('4', List.of('g', 'h', 'i'));
		dictionary.put('5', List.of('j', 'k', 'l'));
		dictionary.put('6', List.of('m', 'n', 'o'));
		dictionary.put('7', List.of('p', 'q', 'r', 's'));
		dictionary.put('8', List.of('t', 'u', 'v'));
		dictionary.put('9', List.of('w', 'x', 'y', 'z'));

		dfs(result, dictionary, digits, 0, new StringBuilder());

		return result;
	}

	private void dfs(List<String> result, Map<Character, List<Character>> dictionary, String digits, int index, StringBuilder path) {
		if (path.length() == digits.length()) {
			result.add(String.valueOf(path));
			return;
		}

		for (Character c : dictionary.get(digits.charAt(index))) {
			dfs(result, dictionary, digits, index + 1, new StringBuilder(path).append(c));
		}
	}

}
