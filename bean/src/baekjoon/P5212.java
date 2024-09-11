package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5212 {
	static int[] dy = new int[] {-1, 0, 1, 0};
	static int[] dx = new int[] {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int maxY = Integer.valueOf(input[0]);
		int maxX = Integer.valueOf(input[1]);

		char[][] map = new char[maxY][maxX];

		for (int y = 0; y < maxY; y++) {
			map[y] = br.readLine().toCharArray();
		}

		int x1 = 10, x2 = 0, y1 = 10, y2 = 0;

		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				if (map[y][x] == 'X') {
					int surrounded = 0;
					for (int d = 0; d < 4; d++) {
						int nextY = y + dy[d];
						int nextX = x + dx[d];
						if (nextY < 0 || nextY == maxY || nextX < 0 || nextX == maxX) {
							surrounded++;
							continue;
						}
						if (map[nextY][nextX] == '.') {
							surrounded++;
						}
					}
					if (surrounded >= 3) {
						map[y][x] = 'O';
					} else {
						x1 = Math.min(x1, x);
						y1 = Math.min(y1, y);
						x2 = Math.max(x2, x);
						y2 = Math.max(y2, y);
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int y = y1; y <= y2; y++) {
			for (int x = x1; x <= x2; x++) {
				if (map[y][x] == 'O') {
					sb.append(".");
				} else {
					sb.append(map[y][x]);
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
