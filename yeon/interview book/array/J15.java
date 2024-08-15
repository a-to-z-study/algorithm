package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J15 {

	public List<List<Integer>> threeSum(int[] nums) {
		int left;
		int right;
		int sum;

		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			left = i + 1;
			right = nums.length - 1;
			while(left < right) {
				sum = nums[i] + nums[left] + nums[right];

				if (sum < 0) {
					left++;
				} else if (sum > 0) {
					right--;
				} else {
					results.add(List.of(nums[i], nums[left], nums[right]));

					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}

					left++;
					right--;
				}
			}
		}

		return results;
	}

}
