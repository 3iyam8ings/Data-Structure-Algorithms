class Solution {
    private void swap(int[] nums , int i, int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right-- ;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        //1. find the breakpoint 
        for(int i = n-2; i>= 0 ; i--){
            if(nums[i]< nums[i+1]){
                idx = i;
                break;
            }
        }

        // if no breakpoint found 
        if(idx== -1){
            reverse(nums, 0 , n- 1);
            return;
        }

        //2.find the greater but smallest prefix 
        for( int i= n-1 ; i> idx ; i--){
            if(nums[i]> nums[idx]){
                swap(nums, i , idx);
                break;
            }
        }
        //3. return final in sorted array
        reverse(nums, idx + 1 , n-1);
    }
}