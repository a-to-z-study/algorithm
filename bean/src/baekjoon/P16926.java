package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class P16926 {
	static int[][] direction = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static boolean[][] rotated;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Pattern pattern = Pattern.compile(" ");
		String[] input1 = pattern.split(br.readLine());
		int n = Integer.parseInt(input1[0]);
		int m = Integer.parseInt(input1[1]);
		int r = Integer.parseInt(input1[2]);

		int[][] arr = new int[n][m];
		int[][] answer = new int[n][m];
		rotated = new boolean[n][m];

		for (int y = 0; y < n; y++) {
			StringTokenizer tokenizer = new StringTokenizer(br.readLine());
			for (int x = 0; x < m; x++) {
				arr[y][x] = Integer.parseInt(tokenizer.nextToken());
			}
		}


		int[] leftTop = new int[] {0, 0};
		int[] rihgtBottom = new int[] {n - 1, m - 1};

		while (leftTop[0] < rihgtBottom[0] && leftTop[1] < rihgtBottom[1]) {
			int[] pos = new int[] {leftTop[0], leftTop[1]};
			int dirIndex = 0;
			while (!rotated[pos[0]][pos[1]]) {
				if (requireRotate(pos, direction[dirIndex], leftTop, rihgtBottom)) {
					dirIndex = (dirIndex + 1) % 4;
				}

				rotated[pos[0]][pos[1]] = true;

				// 기준 위치
				pos[0] += direction[dirIndex][0];
				pos[1] += direction[dirIndex][1];

				// 회전 된 위치
				int[] rotatePos = new int[] {pos[0], pos[1]};
				int rotateDir = dirIndex;
				for (int i = 0; i < r; i++) {
					if (requireRotate(rotatePos, direction[rotateDir], leftTop, rihgtBottom)) {
						rotateDir = (rotateDir + 1) % 4;
					}
					rotatePos[0] += direction[rotateDir][0];
					rotatePos[1] += direction[rotateDir][1];
				}

				answer[rotatePos[0]][rotatePos[1]] = arr[pos[0]][pos[1]];
			}

			leftTop[0]++;
			leftTop[1]++;
			rihgtBottom[0]--;
			rihgtBottom[1]--;
		}

		final StringBuilder sb = new StringBuilder();

		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				sb.append(answer[y][x]).append(" ");
			}
			sb.append(System.lineSeparator());
		}

		System.out.println(sb);
	}

	private static boolean requireRotate(int[] pos, int[] dir, int[] leftTop, int[] rihgtBottom) {
		return pos[0] + dir[0] < leftTop[0] ||
			pos[0] + dir[0] > rihgtBottom[0] ||
			pos[1] + dir[1] < leftTop[1] ||
			pos[1] + dir[1] > rihgtBottom[1];
	}
}
