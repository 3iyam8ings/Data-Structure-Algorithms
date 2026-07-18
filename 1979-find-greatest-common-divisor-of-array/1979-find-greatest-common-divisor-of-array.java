class Solution {
    public int findGCD(int[] nums) {
        int small = nums[0];
        int large = nums[0];
        for(int i =1 ; i < nums.length; i++){
             small = Math.min(small , nums[i]);
             large = Math.max(large , nums[i]);
        }
        return gcd(small , large);
    }
    public int gcd(int a , int b) {
        while( b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a ;
    }
}