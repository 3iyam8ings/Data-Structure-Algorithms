class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int t = 0;
        boolean non = false;

        for ( int x : nums) {
            non |= x > 0;
            t ^= x;
        }
        if (!non) return 0;
        return t == 0 ? n - 1 : n;
    }
}