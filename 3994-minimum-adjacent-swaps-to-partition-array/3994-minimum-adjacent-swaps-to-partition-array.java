class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long ans = 0;
        long mid = 0;
        long high = 0;
        final int MOD = 1_000_000_007;
        for ( int x : nums ){
            if( x < a){
                ans += mid + high;
            }
            else if( x<=b){
                ans += high;
                mid++;
            }
            else{
                high++;
            }
        }
        return (int)(ans % MOD);
    }
}