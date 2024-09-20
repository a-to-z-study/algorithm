package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B1181 {

	// 단어 정렬
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		Set<String> validator = new HashSet<>();
		List<String> words = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String word = reader.readLine();

			if (validator.contains(word))
				continue;

			validator.add(word);
			words.add(word);
		}

		words.sort((a, b) -> {
			if (a.length() != b.length()) {
				return Integer.compare(a.length(), b.length());
			} else {
				return a.compareTo(b);
			}
		});

		StringBuilder builder = new StringBuilder();

		for (String word : words) {
			builder.append(word).append(System.lineSeparator());
		}

		System.out.println(builder);
	}

}
