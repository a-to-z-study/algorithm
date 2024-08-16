package dp;

import java.util.Arrays;

public class J198 {

	public int rob(int[] nums) {
		int[][] dp = new int[nums.length + 1][2];

		if (nums.length < 3) {
			return Arrays.stream(nums).max().getAsInt();
		}

		dp[1][1] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			dp[i + 1][0] = Math.max(dp[i][0], dp[i][1]);
			dp[i + 1][1] = Math.max(dp[i][0] + nums[i], dp[i - 1][1] + nums[i]);
		}

		return Math.max(dp[nums.length][0], dp[nums.length][1]);
	}

}
