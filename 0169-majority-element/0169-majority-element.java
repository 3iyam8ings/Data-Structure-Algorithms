class Solution {
    public int majorityElement(int[] nums) {
        //1. moor's algorithm 
        //2. checking might or might not be present 
       int cnt = 0;
       int el = 0; 
       for(int i = 0 ; i<nums.length ; i++ ) {
          if( cnt == 0) {
            el = nums[i];
            cnt = 1;
          }
          else if( nums[i] == el){
            cnt++ ;
          }
          else {
            cnt--;
          }
       }
       return el;
    }
}