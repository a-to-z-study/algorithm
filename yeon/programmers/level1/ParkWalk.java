package level1;

public class ParkWalk {

	public int[] solution(String[] park, String[] routes) {
		int row_count = park.length;
		int column_count = park[0].length();
		boolean[][] park_array = new boolean[row_count][column_count];
		int[] answer = new int[2];

		for (int i = 0; i < park.length; i++) {
			char[] p = park[i].toCharArray();

			for (int j = 0; j < p.length; j++) {
				if (p[j] == 'S') {
					answer[0] = i;
					answer[1] = j;
				}
				park_array[i][j] = p[j] == 'X';
			}
		}

		for (String route : routes) {
			String[] route_split = route.split(" ");
			String direction = route_split[0];
			int distance = Integer.parseInt(route_split[1]);
			int next_row = answer[0];
			int next_column = answer[1];
			boolean blocked = false;

			switch (direction) {
				case "N":
					for (int i = next_row; i >= Math.max(0, next_row - distance); i--) {
						if (park_array[i][next_column]) {
							blocked = true;
							break;
						}
					}

					next_row -= distance;
					break;
				case "S":
					for (int i = next_row; i < Math.min(row_count, next_row + distance + 1); i++) {
						if (park_array[i][next_column]) {
							blocked = true;
							break;
						}
					}

					next_row += distance;
					break;
				case "W":
					for (int i = next_column; i >= Math.max(0, next_column - distance); i--) {
						if (park_array[next_row][i]) {
							blocked = true;
							break;
						}
					}

					next_column -= distance;
					break;
				case "E":
					for (int i = next_column; i < Math.min(column_count, next_column + distance + 1); i++) {
						if (park_array[next_row][i]) {
							blocked = true;
							break;
						}
					}

					next_column += distance;
					break;
			}

			if (blocked || next_row < 0 || next_row >= row_count || next_column < 0 || next_column >= column_count) {
				continue;
			}

			answer[0] = next_row;
			answer[1] = next_column;
		}

		return answer;
	}

}
