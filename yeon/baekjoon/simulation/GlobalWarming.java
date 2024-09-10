package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GlobalWarming {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = reader.readLine().split(" ");
		int R = Integer.parseInt(firstLine[0]);
		int C = Integer.parseInt(firstLine[1]);

		List<String> map = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			map.add(reader.readLine());
		}

		int[] nr = {-1, 1, 0, 0};
		int[] nc = {0, 0, -1, 1};

		int[] left_top = {10, 10};
		int[] right_bottom = {0, 0};

		char OCEAN = '.';
		char ISLAND = 'X';
		char[][] after_50_years = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = map.get(i);

			for (int j = 0; j < C; j++) {
				char point = line.charAt(j);

				if (point != 'X') {
					after_50_years[i][j] = OCEAN;
					continue;
				}

				int count = 0;

				for (int k = 0; k < 4; k++) {
					int aroundR = i + nr[k];
					int aroundC = j + nc[k];

					if (aroundR < 0 || aroundR >= R
						|| aroundC < 0 || aroundC >= C) {
						count++;
					} else if (map.get(aroundR).charAt(aroundC) == OCEAN) {
						count++;
					}
				}

				if (count >= 3) {
					after_50_years[i][j] = OCEAN;
				} else {
					after_50_years[i][j] = ISLAND;

					if (left_top[0] > i || left_top[1] > j) {
						left_top[0] = Math.min(left_top[0], i);
						left_top[1] = Math.min(left_top[1], j);
					}

					if (right_bottom[0] < i || right_bottom[1] < j) {
						right_bottom[0] = Math.max(right_bottom[0], i);
						right_bottom[1] = Math.max(right_bottom[1], j);
					}
				}
			}
		}

		StringBuilder builder = new StringBuilder();

		for (int i = left_top[0]; i <= right_bottom[0]; i++) {
			for (int j = left_top[1]; j <= right_bottom[1]; j++) {
				builder.append(after_50_years[i][j]);
			}

			if (i < right_bottom[0]) {
				builder.append(System.lineSeparator());
			}
		}

		System.out.println(builder);
	}

}
