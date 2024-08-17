package graph;

import java.util.ArrayList;
import java.util.List;

public class J39 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();

		dfs(results, candidates, target, 0, new ArrayList<>());

		return results;
	}

	private void dfs(List<List<Integer>> results, int[] candidates, int target, int index, List<Integer> temp) {
		int sum = temp.stream().mapToInt(Integer::intValue).sum();

		if (sum == target) {
			results.add(new ArrayList<>(temp));
			return;
		}

		if (sum > target) {
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			temp.add(candidates[i]);
			dfs(results, candidates, target, i, temp);
			temp.remove(temp.size() - 1);
		}
	}

}
