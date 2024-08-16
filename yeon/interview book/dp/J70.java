package dp;

public class J70 {

	public int climbStairs(int n) {
		if (n < 3) {
			return n;
		}

		int[][] dp = new int[n + 1][2];
		dp[1][0] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;

		for (int i = 3; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
		}

		return dp[n][0] + dp[n][1];
	}

}
