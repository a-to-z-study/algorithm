package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1654 {

	// 문제: 랜선 자르기
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int K = Integer.parseInt(tokenizer.nextToken());
		int N = Integer.parseInt(tokenizer.nextToken());

		long[] lines = new long[K];
		long total = 0;

		for (int i = 0; i < K; i++) {
			lines[i] = Long.parseLong(reader.readLine());
			total += lines[i];
		}

		long low = 1;
		long high = total / N;

		while (low <= high) {
			long mid = low + ((high - low) / 2);
			long count = 0;

			for (long line : lines) {
				count += line / mid;
			}

			if (count >= N) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(high);
	}

}
