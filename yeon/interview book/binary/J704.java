package binary;

import java.util.Arrays;

public class J704 {

	public int search1(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return nums[left] == target ? left : -1;
	}

	public int search2(int[] nums, int target) {
		int result = Arrays.binarySearch(nums, target);

		return result >= 0 ? result : -1;
	}

}
