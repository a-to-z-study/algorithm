package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class B1764 {

	// 듣보잡
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());

		Set<String> D = new HashSet<>(); // 들어본 적 없는
		List<String> DBJ = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			D.add(reader.readLine());
		}

		for (int i = 0; i < M; i++) {
			String person = reader.readLine();

			if (D.contains(person)) {
				DBJ.add(person);
			}
		}

		DBJ.sort(String::compareTo);

		StringBuilder builder = new StringBuilder()
			.append(DBJ.size())
			.append(System.lineSeparator())
			.append(String.join(System.lineSeparator(), DBJ));

		System.out.println(builder);
	}

}
