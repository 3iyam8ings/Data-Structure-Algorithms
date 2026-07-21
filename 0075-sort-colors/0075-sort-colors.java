class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        //1. Deutch national flag algorithm
        int low = 0, high = n - 1, mid = 0;
        while( mid<= high){
        
        if(nums[mid] == 0){
            swap( nums, low , mid);
            low++;
            mid++;
        }
        else if(nums[mid] == 1){
            mid++;
        }
        else if(nums[mid] == 2){
            swap(nums, mid , high);
            high--;
        } }
    }
}