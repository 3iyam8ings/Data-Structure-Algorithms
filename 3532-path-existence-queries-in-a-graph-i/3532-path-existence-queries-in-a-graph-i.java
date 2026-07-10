class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // connect array having index i
        int[] cmp = new int[n];
        for(int i=1; i<n; i++){
            // diff b/w 2 consecutive vlues> maxdiff then no path can cross this gap.`
            cmp[i] = cmp[i - 1] + ((nums[i] - nums[i - 1] > maxDiff) ? 1 : 0);
        }
       boolean[] res = new boolean[queries.length];
        for(int i=0; i< queries.length; i++){
            res[i]= (cmp[queries[i][0]] == cmp[queries[i][1]]);
        }
        return res;
    }
}