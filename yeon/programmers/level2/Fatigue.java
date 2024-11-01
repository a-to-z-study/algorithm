package level2;

import java.util.ArrayList;
import java.util.List;

public class Fatigue {

	private int answer = 0;

	public int solution(int k, int[][] dungeons) {
		permutation(dungeons, new boolean[dungeons.length], new ArrayList<>(), k);

		return answer;
	}

	private void permutation(int[][] dungeons, boolean[] visited, List<Integer> temp, int k) {
		if (temp.size() == dungeons.length) {
			// 탐험 시작
			int fatigue = k;
			int count = 0;

			for (int index : temp) {
				if (dungeons[index][0] > fatigue) {
					break;
				}

				fatigue -= dungeons[index][1];
				count++;
			}

			// 정답 갱신
			answer = Math.max(answer, count);

			return;
		}

		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i]) {
				temp.add(i);
				visited[i] = true;
				permutation(dungeons, visited, temp, k);
				temp.remove(temp.size() - 1);
				visited[i] = false;
			}
		}
	}

}
