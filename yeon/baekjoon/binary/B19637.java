package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B19637 {
	// 문제: IF문 좀 대신 써줘

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = reader.readLine().split(" ");

		int N = Integer.parseInt(firstLine[0]); // 칭호의 개수
		int characters = Integer.parseInt(firstLine[1]); // 캐릭터들의 개수
		String[] titles = new String[N]; // 칭호의 이름
		int[] ceiling = new int[N]; // 칭호의 전투력 상한값

		for (int i = 0; i < N; i++) {
			String[] strings = reader.readLine().split(" ");
			titles[i] = strings[0];
			ceiling[i] = Integer.parseInt(strings[1]);
		}

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < characters; i++) {
			int power = Integer.parseInt(reader.readLine());

			int low = 0;
			int high = titles.length - 1;

			while (low < high) {
				int mid = (low + high) / 2;

				if (ceiling[mid] < power) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}

			builder.append(titles[low]);

			if (i < characters - 1) {
				builder.append(System.lineSeparator());
			}
		}

		System.out.println(builder);
	}

}
