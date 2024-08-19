package programmers;

import java.util.HashMap;
import java.util.Map;

public class WalkPark {
	public int[] solution(String[] park, String[] routes) {
		char[][] map = new char[park.length][park[0].length()];
		Map<Character, int[]> directions = new HashMap<>();

		directions.put('E', new int[]{0, 1});
		directions.put('N', new int[]{-1, 0});
		directions.put('W', new int[]{0, -1});
		directions.put('S', new int[]{1, 0});

		int[] point = new int[2];
		boolean findStart = false;
		for (int i = 0; i < park.length; i++) {
			char[] line = park[i].toCharArray();
			map[i] = line;

			if (findStart) {
				continue;
			}

			for (int j = 0; j < line.length; j++) {
				if (line[j] == 'S') {
					findStart = true;
					point[0] = i;
					point[1] = j;
				}
			}
		}

		int h = map.length - 1;
		int w = map[0].length - 1;

		for (String route : routes) {
			char op = route.charAt(0);
			int n = route.charAt(2) - '0';

			int[] unitDir = directions.get(op);
			int nextH = point[0];
			int nextW = point[1];
			boolean canMove = true;

			for (int i = 0; i < n; i++) {
				nextH += unitDir[0];
				nextW += unitDir[1];
				if (nextH < 0 || nextH > h || nextW < 0 || nextW > w ||
					map[nextH][nextW] == 'X'
				) {
					canMove = false;
					break;
				}
			}
			if (canMove) {
				point[0] = nextH;
				point[1] = nextW;
			}
		}

		return point;
	}
}
