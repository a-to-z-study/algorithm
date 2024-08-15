package array;

public class J42 {

	public int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int volume = 0;
		int leftMax = height[left];
		int rightMax = height[right];

		while (left < right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);

			if (leftMax <= rightMax) {
				volume += leftMax - height[left];
				left++;
			} else {
				volume += rightMax - height[right];
				right--;
			}
		}

		return volume;
	}

}
