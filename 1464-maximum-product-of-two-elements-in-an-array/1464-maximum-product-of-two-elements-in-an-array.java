class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int cur = nums[0];
        int result = 0;
        for( int i = 1; i< n; i++){
            result = Math.max(result, (nums[i]-1) * (cur-1)) ;
            cur = Math.max(cur, nums[i]);
        }
        return result;
    }
}