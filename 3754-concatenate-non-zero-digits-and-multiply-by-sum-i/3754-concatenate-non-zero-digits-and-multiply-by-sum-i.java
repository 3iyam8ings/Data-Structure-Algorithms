class Solution {
    public long sumAndMultiply(int n) {

        int sum = 0;
        long rev = 0;

        while (n > 0) {
            int d = n % 10;

            if (d != 0) {
                sum += d;
                rev = rev * 10 + d;
            }
            n /= 10;
        }
        long x = 0;
        while (rev > 0) {
            x = x * 10 + rev % 10;
            rev /= 10;
        }
        return x * sum;
    }
}