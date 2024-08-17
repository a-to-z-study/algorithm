package graph;

import java.util.ArrayList;
import java.util.List;

public class J46 {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] used = new boolean[nums.length];

		for (int i = 0; i < nums.length; i++) {
			dfs(result, nums, new ArrayList<>(), used);
		}

		return result;
	}

	private void dfs(List<List<Integer>> result, int[] nums, List<Integer> temp, boolean[] used) {
		if (temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				used[i] = true;
				temp.add(nums[i]);
				dfs(result, nums, temp, used);
				temp.remove(temp.size() - 1);
				used[i] = false;
			}
		}
	}

}
