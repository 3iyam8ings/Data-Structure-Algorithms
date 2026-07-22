class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int r = nums1.length - 1;
        while(n>0 && m>0){
            if(nums2[n - 1] >= nums1[m - 1]){
                nums1[r] = nums2[n-1];
                n-- ;
            }
            else {
                nums1[r] = nums1[m - 1];
                m-- ;
            }
            r--;
        }
        while(n>0) {
            nums1[r] = nums2[n - 1];
            n--;
            r--;
        }
    }
}