package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Pattern;

public class P20165 {
	static int[] dy = new int[] {0, 0, 1, -1};
	static int[] dx = new int[] {1, -1, 0, 0};

	static boolean TOPPLE = true;

	public static void main(String[] args) throws IOException {
		final Map<String, Integer> dir = Map.of(
			"E", 0,
			"W", 1,
			"S", 2,
			"N", 3
		);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final Pattern p = Pattern.compile(" ");

		String[] input1 = p.split(br.readLine());

		int my = Integer.parseInt(input1[0]);
		int mx = Integer.parseInt(input1[1]);
		int round = Integer.parseInt(input1[2]);

		int[][] map = new int[my][mx];
		boolean[][] domino = new boolean[my][mx];

		for (int i = 0; i < my; i++) {
			String[] mapLine = p.split(br.readLine());
			for (int j = 0; j < mx; j++) {
				map[i][j] = Integer.parseInt(mapLine[j]);
			}
		}


		int score = 0;

		for (int r = 0; r < round; r++) {
			String[] attack = p.split(br.readLine());

			int ay = Integer.parseInt(attack[0]) - 1;
			int ax = Integer.parseInt(attack[1]) - 1;
			int ad = dir.get(attack[2]);

			int attackCount = 1;

			while (attackCount > 0 && (ay >= 0 && ay < my && ax >= 0 && ax < mx)) {
				if (domino[ay][ax] != TOPPLE && map[ay][ax] > attackCount) {
					attackCount = map[ay][ax];
				}

				if (domino[ay][ax] != TOPPLE) {
					domino[ay][ax] = TOPPLE;
					score++;
				}

				ay += dy[ad];
				ax += dx[ad];
				attackCount--;
			}

			String[] defense = p.split(br.readLine());

			domino[Integer.parseInt(defense[0]) - 1][Integer.parseInt(defense[1]) - 1] = !TOPPLE;
		}

		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < my; y++) {
			for (int x = 0; x < mx; x++) {
				if (domino[y][x] == TOPPLE) {
					sb.append("F");
				} else {
					sb.append("S");
				}
				sb.append(" ");
			}
			sb.append(System.lineSeparator());
		}

		sb.delete(sb.length() - 2, sb.length() - 1);

		System.out.println(score);
		System.out.println(sb);
	}
}
