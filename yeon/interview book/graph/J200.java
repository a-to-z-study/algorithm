package graph;

public class J200 {

	public int numIslands(char[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(i, j, grid);
				}
			}
		}

		return count;
	}

	int[] dx = {0, 0, 1, -1};
	int[] dy = {1, -1, 0, 0};

	private void dfs(int i, int j, char[][] grid) {
		grid[i][j] = 0;

		for (int k = 0; k < 4; k++) {
			if (i + dx[k] >= 0 && i + dx[k] < grid.length && j + dy[k] >= 0 && j + dy[k] < grid[0].length && grid[i + dx[k]][j + dy[k]] == '1') {
				dfs(i + dx[k], j + dy[k], grid);
			}
		}
	}

}
