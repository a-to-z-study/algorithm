package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6550 {

	// 부분 문자열
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(line);
			String S = tokenizer.nextToken();
			String T = tokenizer.nextToken();

			solution(S, T);
		}
	}

	private static void solution(String S, String T) {
		if (S.length() > T.length()) {
			System.out.println("No");
		} else {
			int indexS = 0;
			int indexT = 0;
			String answer = "No";

			while (indexT < T.length()) {
				if (S.charAt(indexS) == T.charAt(indexT)) {
					indexS++;
				}

				if (indexS == S.length()) {
					answer = "Yes";
					break;
				}

				indexT++;
			}

			System.out.println(answer);
		}
	}

}
