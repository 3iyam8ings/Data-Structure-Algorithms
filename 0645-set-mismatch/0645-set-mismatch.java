class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        long sn = (long) n * (n + 1) / 2;
        long s2n = (long) n * (n + 1) * (2L * n + 1) / 6;

        long s = 0;
        long s2 = 0;

        for (int num : nums) {
            s += num;
            s2 += (long) num * num;
        }

        long val1 = s - sn;      // x - y
        long val2 = s2 - s2n;    // x² - y²

        val2 /= val1;            // x + y

        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new int[]{(int) x, (int) y};
    }
}