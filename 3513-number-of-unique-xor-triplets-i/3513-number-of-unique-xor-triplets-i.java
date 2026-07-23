class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        int power = (32 - Integer.numberOfLeadingZeros(n) - 3 / (n+1));
        return 1 << power;
    }
}