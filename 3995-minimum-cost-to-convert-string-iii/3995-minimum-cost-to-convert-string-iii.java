class Solution {

    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {

        int n = source.length();
        int m = rules.size();

        long[] cost = new long[m];

        for (int i = 0; i < m; i++) {
            String pat = rules.get(i).get(0);

            int wild = 0;
            for (char ch : pat.toCharArray()) {
                if (ch == '*') wild++;
            }

            cost[i] = costs[i] + wild;
        }

        long INF = (long)1e16;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {

            if (source.charAt(i - 1) == target.charAt(i - 1)) {
                dp[i] = dp[i - 1];
            }

            for (int j = 0; j < m; j++) {

                String pat = rules.get(j).get(0);
                String rep = rules.get(j).get(1);
                int len = pat.length();

                if (i < len || dp[i - len] == INF) continue;

                if (check(source, target, i - len, pat, rep)) {
                    dp[i] = Math.min(dp[i], dp[i - len] + cost[j]);
                }
            }
        }

        return dp[n] == INF ? -1 : (int) dp[n];
    }

    private boolean check(String source, String target, int start,
                          String pat, String rep) {

        for (int i = 0; i < pat.length(); i++) {

            if (pat.charAt(i) != '*' &&
                pat.charAt(i) != source.charAt(start + i)) {
                return false;
            }

            if (rep.charAt(i) != target.charAt(start + i)) {
                return false;
            }
        }

        return true;
    }
}