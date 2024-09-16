package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11663 {
	// 문제: 선분 위의 점

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = reader.readLine().split(" ");
		int N = Integer.parseInt(firstLine[0]); // 점의 개수
		int M = Integer.parseInt(firstLine[1]); // 선분의 개수

		String[] dots_string = reader.readLine().split(" ");
		int[] dots = Arrays.stream(dots_string)
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray(); // 점의 좌표

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < M; i++) {
			String[] line = reader.readLine().split(" ");
			int start = Integer.parseInt(line[0]);
			int end = Integer.parseInt(line[1]);

			int low = 0;
			int high = N - 1;

			while (low < high) {
				int mid = (low + high) / 2;

				if (dots[mid] < start) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}

			int start_index = dots[low] < start ? -1 : low;

			low = 0;
			high = N - 1;

			while (low < high) {
				int mid = (low + high) / 2;

				if (dots[mid] < end) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}

			int end_index = dots[low] > end ? low - 1: low;

			if (start_index == -1) {
				builder.append(0);
			} else {
				builder.append(end_index - start_index + 1);
			}

			if (i < M - 1) {
				builder.append(System.lineSeparator());
			}
		}

		System.out.println(builder);
	}

}
