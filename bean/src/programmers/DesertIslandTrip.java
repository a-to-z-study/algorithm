package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DesertIslandTrip {
	static int[][] dir = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	static boolean[][] passsed;
	static int maxY;
	static int maxX;

	public int[] solution(String[] maps) {
		List<Integer> answer = new ArrayList<>();

		maxY = maps.length;
		maxX = maps[0].length();
		passsed = new boolean[maxY][maxX];

		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				if (maps[y].charAt(x) == 'X' || passsed[y][x]) {
					continue;
				}

				answer.add(find(y, x, maps));
			}
		}

		return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
	}

	private int find(int y, int x, String[] maps) {
		if (y < 0 || y == maxY ||
			x < 0 || x == maxX ||
			passsed[y][x] || maps[y].charAt(x) == 'X') {

			return 0;
		}

		passsed[y][x] = true;

		return (maps[y].charAt(x) - '0')
			+ find(y + dir[0][0], x + dir[0][1], maps)
			+ find(y + dir[1][0], x + dir[1][1], maps)
			+ find(y + dir[2][0], x + dir[2][1], maps)
			+ find(y + dir[3][0], x + dir[3][1], maps);
	}

	public static void main(String[] args) {
		final int[] solution = new DesertIslandTrip().solution(
			new String[] {
				"X591X", "X1X5X", "X231X", "1XXX1"
			}
		);
		for (int i : solution) {
			System.out.println(i);
		}
	}
}
