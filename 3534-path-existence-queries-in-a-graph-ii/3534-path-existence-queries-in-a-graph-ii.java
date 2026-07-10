import java.util.*;

class Solution {

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] ans = new int[queries.length];

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] sortedNums = new int[n];
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            sortedNums[i] = pairs[i][0];
            pos[pairs[i][1]] = i;
        }

        int LOG = Integer.SIZE - Integer.numberOfLeadingZeros(n) + 1;
        int[][] jump = new int[n][LOG];

        // Build first jump using two pointers
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r + 1 < n && sortedNums[r + 1] - sortedNums[i] <= maxDiff) {
                r++;
            }
            jump[i][0] = r;
        }

        // Binary lifting table
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[i][k] = jump[jump[i][k - 1]][k - 1];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int u = pos[queries[i][0]];
            int v = pos[queries[i][1]];

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            ans[i] = solve(u, v, jump, LOG);
        }

        return ans;
    }

    private int solve(int u, int v, int[][] jump, int LOG) {

        if (u == v)
            return 0;

        if (jump[u][0] >= v)
            return 1;

        if (jump[u][LOG - 1] < v)
            return -1;

        int res = 0;

        for (int k = LOG - 1; k >= 0; k--) {
            if (jump[u][k] < v) {
                res += 1 << k;
                u = jump[u][k];
            }
        }

        return res + 1;
    }
}