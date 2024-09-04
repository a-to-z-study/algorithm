package level2;

public class TicTacToeAlone {

	public int solution(String[] board) {
		int countO = 0;
		int countX = 0;

		boolean winO = false;
		boolean winX = false;

		// 가로
		for (String line : board) {
			int tempO = 0;
			int tempX = 0;

			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == 'O') {
					countO++;
					tempO++;
				} else if (line.charAt(i) == 'X') {
					countX++;
					tempX++;
				}
			}

			if (tempO == 3) {
				winO = true;
			}

			if (tempX == 3) {
				winX = true;
			}
		}

		// 세로
		for (int i = 0; i < 3; i++) {
			int tempO = 0;
			int tempX = 0;

			for (int j = 0; j < 3; j++) {
				if (board[j].charAt(i) == 'O') {
					tempO++;
				} else if (board[j].charAt(i) == 'X') {
					tempX++;
				}
			}

			if (tempO == 3) {
				winO = true;
			}

			if (tempX == 3) {
				winX = true;
			}
		}

		// 대각선
		int tempO = 0;
		int tempX = 0;

		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(i) == 'O') {
				tempO++;
			} else if (board[i].charAt(i) == 'X') {
				tempX++;
			}
		}

		if (tempO == 3) {
			winO = true;
		}

		if (tempX == 3) {
			winX = true;
		}

		tempO = 0;
		tempX = 0;

		for (int i = 0; i < 3; i++) {
			if (board[2 - i].charAt(i) == 'O') {
				tempO++;
			} else if (board[2 - i].charAt(i) == 'X') {
				tempX++;
			}
		}

		if (tempO == 3) {
			winO = true;
		}

		if (tempX == 3) {
			winX = true;
		}

		if (winO && !winX && countO == countX + 1) {
			return 1;
		}

		if (!winO && winX && countO == countX) {
			return 1;
		}

		if (!winO && !winX && (countO == countX || countO == countX + 1)) {
			return 1;
		}

		return 0;
	}

}
