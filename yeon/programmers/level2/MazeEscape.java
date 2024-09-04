package level2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MazeEscape {

	public int solution(String[] maps) {
		int[] S = {-1, -1}; // 시작 지점
		int[] E = {-1, -1}; // 출구
		int[] L = {-1, -1}; // 레버

		// 필요한 좌표 찾기
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length(); j++) {
				if (maps[i].charAt(j) == 'S') {
					S = new int[]{i, j};
				} else if (maps[i].charAt(j) == 'E') {
					E = new int[]{i, j};
				} else if (maps[i].charAt(j) == 'L') {
					L = new int[]{i, j};
				}
			}
		}

		// 레버까지 최단 경로 BFS 탐색하기
		int answer = -1;

		int[][] visited = new int[maps.length][maps[0].length()];

		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = Integer.MAX_VALUE;
			}
		}

		Deque<List<Integer>> queue = new ArrayDeque<>();
		queue.addLast(List.of(S[0], S[1], 0));

		int[] nr = {-1, 1, 0, 0};
		int[] nc = {0, 0, -1, 1};

		boolean findL = false;

		while (!queue.isEmpty() && !findL) {
			List<Integer> current = queue.pollFirst();

			int nextCost = current.get(2) + 1;

			for (int i = 0; i < 4; i++) {
				int nextR = current.get(0) + nr[i];
				int nextC = current.get(1) + nc[i];

				if (nextR == L[0] && nextC == L[1]) {
					answer = nextCost;
					findL = true;
					break;
				}

				if (0 <= nextR && nextR < maps.length
					&& 0 <= nextC && nextC < maps[0].length()
					&& nextCost < visited[nextR][nextC]
					&& maps[nextR].charAt(nextC) != 'X')
				{
					visited[nextR][nextC] = nextCost;
					queue.addLast(List.of(nextR, nextC, nextCost));
				}
			}
		}

		if (!findL) {
			return -1;
		}

		// 출구까지 최단 경로 BFS 탐색하기
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = Integer.MAX_VALUE;
			}
		}

		queue = new ArrayDeque<>();
		queue.addLast(List.of(L[0], L[1], 0));

		while (!queue.isEmpty()) {
			List<Integer> current = queue.pollFirst();

			int nextCost = current.get(2) + 1;

			for (int i = 0; i < 4; i++) {
				int nextR = current.get(0) + nr[i];
				int nextC = current.get(1) + nc[i];

				if (nextR == E[0] && nextC == E[1]) {
					return answer + nextCost;
				}

				if (0 <= nextR && nextR < maps.length
					&& 0 <= nextC && nextC < maps[0].length()
					&& nextCost < visited[nextR][nextC]
					&& maps[nextR].charAt(nextC) != 'X')
				{
					visited[nextR][nextC] = nextCost;
					queue.addLast(List.of(nextR, nextC, nextCost));
				}
			}
		}

		return -1;
	}

}
