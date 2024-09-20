package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class B20291 {

	// 파일 정리
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());

		Map<String, Integer> counter = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String extension = reader.readLine().split("\\.")[1];
			counter.put(extension, counter.getOrDefault(extension, 0) + 1);
		}

		System.out.println(counter.entrySet().stream()
				.sorted((a, b) -> a.getKey().compareTo(b.getKey()))
				.map(entry -> entry.getKey() + " " + entry.getValue())
				.collect(Collectors.joining(System.lineSeparator())));
	}

}
