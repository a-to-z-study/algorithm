package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B9342 {

	// 염색체
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int T = Integer.parseInt(reader.readLine());

		String INFECTED = "Infected!";
		String GOOD = "Good";

		Set<Character> start_alphabets = new HashSet<>(List.of('A', 'B', 'C', 'D', 'E', 'F'));

		for (int i = 0; i < T; i++) {
			String word = reader.readLine();
			int index = 0;

			if (word.length() < 3) {
				builder.append(GOOD).append(System.lineSeparator());
				continue;
			}

			// 문자열은 {A, B, C, D, E, F} 중 0개 또는 1개로 시작해야 한다
			if (start_alphabets.contains(word.charAt(index))) {
				index++;
			}

			// 그 다음에는 A가 하나 또는 그 이상 있어야 한다
			if (word.charAt(index) == 'A') {
				while (index < word.length() && word.charAt(index) == 'A') {
					index++;
				}
			} else if (!(index - 1 == 0 && word.charAt(0) == 'A')) {
				builder.append(GOOD).append(System.lineSeparator());
				continue;
			}

			// 그 다음에는 F가 하나 또는 그 이상 있어야 한다
			if (word.charAt(index) == 'F') {
				while (index < word.length() && word.charAt(index) == 'F') {
					index++;
				}
			} else {
				builder.append(GOOD).append(System.lineSeparator());
				continue;
			}

			// 그 다음에는 C가 하나 또는 그 이상 있어야 한다
			if (word.charAt(index) == 'C') {
				while (index < word.length() && word.charAt(index) == 'C') {
					index++;
				}
			} else {
				builder.append(GOOD).append(System.lineSeparator());
				continue;
			}

			// 그 다음에는 {A, B, C, D, E, F} 중 0개 또는 1개가 있으며, 더 이상의 문자는 없어야 한다
			if (index == word.length() || (index == word.length() - 1 && start_alphabets.contains(word.charAt(index)))) {
				builder.append(INFECTED).append(System.lineSeparator());
			} else {
				builder.append(GOOD).append(System.lineSeparator());
			}
		}

		System.out.println(builder);
	}

}
