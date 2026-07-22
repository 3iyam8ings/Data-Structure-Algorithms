class Solution {
    public int findDuplicate(int[] nums) {
      //1. optimal way : using cyclic linked list followed by tortoise method(have a hare and tortoise where hare moves 2 steps and tortoise moves 1 step at a time ) followed by slow and fast with 1 step only to detect the duplicate 
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while( slow != fast) ;

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}