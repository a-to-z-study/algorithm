package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11663 {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int totalPoint = Integer.parseInt(tokenizer.nextToken());
		int totalLine = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(br.readLine());
		int[] points = new int[totalPoint];
		for (int i = 0; i < totalPoint; i++) {
			points[i] = Integer.parseInt(tokenizer.nextToken());
		}

		Arrays.sort(points);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < totalLine; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int answer = getPoints(points,
				Integer.parseInt(tokenizer.nextToken()),
				Integer.parseInt(tokenizer.nextToken())
			);
			builder.append(answer).append(System.lineSeparator());
		}
		builder.deleteCharAt(builder.length() - 1);

		System.out.println(builder);
	}

	private static int getPoints(int[] points, int start, int end) {
		int lt = 0;
		int rt = points.length - 1;
		int mid = 0;

		if (points[rt] < start) {
			return 0;
		}

		while (lt < rt) {
			mid = (lt + rt) / 2;

			if (points[mid] < start) {
				lt = mid + 1;
			} else {
				rt = mid;
			}
		}

		while (rt < points.length) {
			if (points[rt] > end) {
				break;
			}

			if (points[rt] == end) {
				rt++;
				break;
			}

			rt++;
		}

		return rt - lt;
	}
}
