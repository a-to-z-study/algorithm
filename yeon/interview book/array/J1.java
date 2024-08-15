package array;

import java.util.HashMap;
import java.util.Map;

public class J1 {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> counter = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (counter.containsKey(target - nums[i])) {
				return new int[]{counter.get(target - nums[i]), i};
			} else {
				counter.put(nums[i], i);
			}
		}

		return new int[]{};
	}

}
