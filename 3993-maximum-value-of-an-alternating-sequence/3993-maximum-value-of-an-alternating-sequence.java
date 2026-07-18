class Solution {
    public long maximumValue(int n, int s, int m) {
       if( n == 1) return s;
        long k = n / 2L;
        return s + k * (m - 1L) + 1;
    }
}