package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609 {

	// 회문
	public static void main(String[] args) throws IOException {
		// 회문: 0
		// 유사 회문: 1
		// 그 외: 2

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int T = Integer.parseInt(reader.readLine());

		for (int i = 0; i < T; i++) {
			String string = reader.readLine();

			builder.append(validate(0, string.length() - 1, string, 0))
				.append(System.lineSeparator());
		}

		System.out.println(builder);
	}

	private static int validate(int start, int end, String string, int deleted) {
		if (deleted >= 2) {
			return 2;
		}

		while (start < end) {
			if (string.charAt(start) == string.charAt(end)) {
				start++;
				end--;
			} else {
				return Math.min(validate(start + 1, end, string, deleted + 1), validate(start, end - 1, string, deleted + 1));
			}
		}

		return deleted;
	}

}
