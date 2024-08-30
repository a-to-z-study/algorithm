package level2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RicochetRobot {

	public int solution(String[] board) {

		int row = board.length;
		int col = board[0].length();

		int startR = -1;
		int startC = -1;

		for (int i = 0; i < row; i++) {
			if (startR >= 0)
				break;

			for (int j = 0; j < col; j++) {
				if (board[i].charAt(j) == 'R') {
					startR = i;
					startC = j;
					break;
				}
			}
		}

		int[][] distance = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}

		Deque<List<Integer>> queue = new ArrayDeque<>();
		queue.addLast(List.of(0, startR, startC));  // distance, row, col

		int[] nextR = {-1, 1, 0, 0};
		int[] nextC = {0, 0, -1, 1};

		while (!queue.isEmpty()) {
			List<Integer> robot = queue.pollFirst();
			int cost = robot.get(0);
			int currentR = robot.get(1);
			int currentC = robot.get(2);

			for (int i = 0; i < 4; i++) {
				int tempR = currentR;
				int tempC = currentC;
				boolean moved = false;

				while (tempR + nextR[i] >= 0 && tempR + nextR[i] < row
					&& tempC + nextC[i] >= 0 && tempC + nextC[i] < col
					&& board[tempR + nextR[i]].charAt(tempC + nextC[i]) != 'D') {

					moved = true;

					tempR += nextR[i];
					tempC += nextC[i];
				}

				if (board[tempR].charAt(tempC) == 'G') {
					return cost + 1;
				}

				if (moved && distance[tempR][tempC] > cost) {
					distance[tempR][tempC] = cost;
					queue.addLast(List.of(cost + 1, tempR, tempC));
				}
			}
		}

		return -1;
	}

}
