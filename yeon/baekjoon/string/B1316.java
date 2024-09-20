package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B1316 {

	// 그룹 단어 체커
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int answer = 0;

		for (int i = 0; i < N; i++) {
			String word = reader.readLine();
			Set<Character> validator = new HashSet<>();
			int index = 0;
			boolean isGroupWord = true;

			while (index < word.length()) {
				char current = word.charAt(index);

				if (validator.contains(current)) {
					isGroupWord = false;
					break;
				}

				validator.add(current);

				while (index + 1 < word.length() && word.charAt(index + 1) == current) {
					index++;
				}

				index++;
			}

			if (isGroupWord) {
				answer++;
			}
		}

		System.out.println(answer);
	}

}
