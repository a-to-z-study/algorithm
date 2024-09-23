package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B20437 {

	// 문자열 게임 2
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int T = Integer.parseInt(reader.readLine());

		for (int i = 0; i < T; i++) {
			String W = reader.readLine();
			int K = Integer.parseInt(reader.readLine());

			if (K == 1) {
				builder.append("1 1")
					.append(System.lineSeparator());

				continue;
			}

			int[] counter = new int[26];

			for (int j = 0; j < W.length(); j++) {
				counter[W.charAt(j) - 'a']++;
			}

			int min_length = 100_000;
			int max_length = 0;

			for (int start = 0; start < W.length(); start++) {
				if (counter[W.charAt(start) - 'a'] < K)
					continue;

				int count = 1;

				for (int end = start + 1; end < W.length(); end++) {
					if (W.charAt(start) == W.charAt(end))
						count++;

					if (count == K) {
						int length = end - start + 1;

						min_length = Math.min(min_length, length);
						max_length = Math.max(max_length, length);
						break;
					}
				}
			}

			if (min_length != 100_000) {
				builder.append(min_length)
					.append(" ")
					.append(max_length);
			} else {
				builder.append(-1);
			}

			builder.append(System.lineSeparator());
		}

		System.out.println(builder);
	}

}
