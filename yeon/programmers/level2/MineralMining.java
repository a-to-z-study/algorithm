package level2;

import java.util.ArrayList;
import java.util.List;

public class MineralMining {

	public int solution(int[] picks, String[] minerals) {
		int group_count = 0;
		for (int pick: picks) {
			group_count += pick;
		}

		List<List<Integer>> groups = new ArrayList<>();

		int di = 0;
		int ir = 0;
		int st = 0;
		int count = 0;

		for (String mineral : minerals) {
			if (groups.size() >= group_count) {
				break;
			}

			if (mineral.equals("diamond")) {
				di++;
			} else if (mineral.equals("iron")) {
				ir++;
			} else {
				st++;
			}

			count++;

			if (count == 5) {
				groups.add(List.of(di, ir, st));
				di = 0;
				ir = 0;
				st = 0;
				count = 0;
			}
		}

		if (count > 0) {
			groups.add(List.of(di, ir, st));
		}

		groups.sort((a, b) -> {
			if (a.get(0) != b.get(0)) {
				return b.get(0) - a.get(0);
			} else {
				if (a.get(1) != b.get(1)) {
					return b.get(1) - a.get(1);
				} else {
					return b.get(2) - a.get(2);
				}
			}
		});

		int answer = 0;

		for (List<Integer> g : groups) {

			if (picks[0] > 0) {
				answer += g.get(0) * 1;
				answer += g.get(1) * 1;
				answer += g.get(2) * 1;

				picks[0]--;
			} else if (picks[1] > 0) {
				answer += g.get(0) * 5;
				answer += g.get(1) * 1;
				answer += g.get(2) * 1;

				picks[1]--;
			} else if (picks[2] > 0) {
				answer += g.get(0) * 25;
				answer += g.get(1) * 5;
				answer += g.get(2) * 1;

				picks[2]--;
			} else {
				break;
			}
		}

		return answer;
	}
	
}
