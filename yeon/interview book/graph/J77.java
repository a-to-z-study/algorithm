package graph;

import java.util.ArrayList;
import java.util.List;

public class J77 {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();

		dfs(result, new ArrayList<>(), 1, n, k);

		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> temp, int start, int n, int k) {
		if (temp.size() == k) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int i = start; i <= n; i++) {
			temp.add(i);
			dfs(result, temp, i + 1, n, k);
			temp.remove(temp.size() - 1);
		}
	}

}
