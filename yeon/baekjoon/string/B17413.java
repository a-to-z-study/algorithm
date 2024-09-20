package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B17413 {

	// 단어 뒤집기 2
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string = reader.readLine();
		StringBuilder builder = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();

		char tag_open = '<';
		char tag_close = '>';
		int index = 0;

		while (index < string.length()) {
			if (string.charAt(index) == tag_open) {
				while (string.charAt(index) != tag_close) {
					builder.append(string.charAt(index));
					index++;
				}

				builder.append(string.charAt(index));
				index++;
 			} else {
				while (index < string.length() && string.charAt(index) != ' ' && string.charAt(index) != tag_open) {
					stack.addLast(string.charAt(index));
					index++;
				}

				while (!stack.isEmpty()) {
					builder.append(stack.pollLast());
				}

				if (index < string.length() && string.charAt(index) == ' ') {
					builder.append(' ');
					index++;
				}
			}
		}

		System.out.println(builder);
	}

}
