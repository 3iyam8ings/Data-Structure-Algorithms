import java.util.*;

class Solution {
    static int[][] dp = new int[501][501];
    static int[] sum = new int[501];

    static int f(int l, int r) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        int ans = 0;

        for (int m = l; m < r; m++) {
            int leftSum = sum[m + 1] - sum[l];
            int rightSum = sum[r + 1] - sum[m + 1];

            if (leftSum <= rightSum) {
                ans = Math.max(ans, leftSum + f(l, m));
            }

            if (leftSum >= rightSum) {
                ans = Math.max(ans, rightSum + f(m + 1, r));
            }

            // Pruning branch
            if (2 * Math.min(leftSum, rightSum) <= ans) {
                break;
            }
        }

        return dp[l][r] = ans;
    }

    public static int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        // Prefix sum
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stoneValue[i];
        }

        // Initialize dp with -1
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 0, n + 1, -1);
        }

        return f(0, n - 1);
    }
}
