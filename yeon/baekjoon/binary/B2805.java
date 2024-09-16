package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2805 {

	// 문제: 나무 자르기
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		long M = Long.parseLong(tokenizer.nextToken());

		long[] trees = Arrays.stream(reader.readLine().split(" "))
			.mapToLong(Long::parseLong)
			.toArray();

		long low = 0;
		long high = Arrays.stream(trees).max().getAsLong();

		while (low + 1 < high) {
			long mid = low + ((high - low) / 2);
			long total = 0;

			for (long tree : trees) {
				total += Math.max(tree - mid, 0);
			}

			if (total >= M) {
				low = mid;
			} else {
				high = mid;
			}
		}

		System.out.println(low);
	}

}
