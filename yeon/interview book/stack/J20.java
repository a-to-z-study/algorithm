package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class J20 {

	public boolean isValid(String s) {
		Map<Character, Character> pairs = new HashMap<>();
		pairs.put(')', '(');
		pairs.put('}', '{');
		pairs.put(']', '[');

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && pairs.containsKey(c) && stack.peek() == pairs.get(c)) {
				stack.pop();
			} else if (stack.isEmpty() && pairs.containsKey(c)) {
				return false;
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty();
	}

}
