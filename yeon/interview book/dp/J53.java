package dp;

import java.util.Arrays;

public class J53 {

	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length + 1];
		dp[0] = -10_000;

		for (int i = 0; i < nums.length; i++) {
			dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
		}

		return Arrays.stream(dp).max().getAsInt();
	}

}
