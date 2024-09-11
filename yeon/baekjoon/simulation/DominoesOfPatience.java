package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DominoesOfPatience {

	enum Direction {
		E(0, 1),
		W(0, -1),
		S(1, 0),
		N(-1, 0);

		public final int x;
		public final int y;

		Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// 문제 20165
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		StringBuilder builder = new StringBuilder();

		int N = Integer.parseInt(tokenizer.nextToken()); // 행 개수
		int M = Integer.parseInt(tokenizer.nextToken()); // 열 개수
		int R = Integer.parseInt(tokenizer.nextToken()); // 라운드 횟수

		int[][] gameBoard = new int[N][M]; // 게임판

		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());

			for (int j = 0; j < M; j++) {
				gameBoard[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		String[][] dominoes = new String[N][M]; // 도미노의 현재 상태
		String S = "S"; // 서 있는 상태
		String F = "F"; // 넘어진 상태

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dominoes[i][j] = S;
			}
		}

		int score = 0; // 공격수의 점수

		for (int i = 0; i < R; i++) {
			// 공격수 행동
			tokenizer = new StringTokenizer(reader.readLine());
			int X = Integer.parseInt(tokenizer.nextToken()) - 1; // X행
			int Y = Integer.parseInt(tokenizer.nextToken()) - 1; // Y열
			Direction D = Direction.valueOf(tokenizer.nextToken()); // 방향

			if (dominoes[X][Y].equals(S)) {
				int height = gameBoard[X][Y];

				while (height > 0 && X < N && Y < M && X >= 0 && Y >= 0) {
					if (dominoes[X][Y].equals(S)) {
						height = Math.max(height, gameBoard[X][Y]);
						score++;
					}

					dominoes[X][Y] = F;
					X += D.x;
					Y += D.y;
					height--;
				}
			}

			// 수비수 행동
			tokenizer = new StringTokenizer(reader.readLine());
			X = Integer.parseInt(tokenizer.nextToken()) - 1; // X행
			Y = Integer.parseInt(tokenizer.nextToken()) - 1; // Y열
			dominoes[X][Y] = S; // 도미노 다시 세우기
		}

		builder.append(score)
			.append(System.lineSeparator());

		for (String[] line : dominoes) {
			builder.append(String.join(" ", line))
				.append(System.lineSeparator());
		}

		builder.deleteCharAt(builder.length() - 1);

		System.out.println(builder);
	}

}
