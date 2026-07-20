class Solution {
    public int maxSubArray(int[] nums) {
        //1. start with smallest possible value 
        int maxSum = nums[0];
        int curSum = 0;
        for( int num : nums ){
            curSum += num;
        //2. initialise global maximun found fso far 
            if( curSum > maxSum) {
                maxSum = curSum;
            }
        //3. if sum -ve discard it 
        if( curSum < 0){
            curSum = 0;
        }
        }
        return maxSum;
    }
}