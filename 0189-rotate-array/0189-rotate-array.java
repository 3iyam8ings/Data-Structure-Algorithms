class Solution {
    private void reverse(int[] nums, int left , int right){
        while(left < right){
            swap(nums, left , right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k =  k % n ;
        if( k== 0) return ;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k -1);
        reverse(nums, k , n - 1);
    }
}