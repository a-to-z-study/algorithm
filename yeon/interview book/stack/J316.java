package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class J316 {

	public String removeDuplicateLetters(String s) {
		Map<Character, Integer> counter = new HashMap<>();
		Map<Character, Boolean> used = new HashMap<>();
		Deque<Character> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {
			counter.put(c, counter.getOrDefault(c, 0) + 1);
		}

		for (char c : s.toCharArray()) {
			counter.put(c, counter.get(c) - 1);

			if (used.get(c) != null && used.get(c)) {
				continue;
			}

			while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
				used.put(stack.pop(), false);
			}

			stack.push(c);
			used.put(c, true);
		}

		StringBuilder stringBuilder = new StringBuilder();
		while (!stack.isEmpty()) {
			stringBuilder.append(stack.pollFirst());
		}

		return stringBuilder.toString();
	}

}
