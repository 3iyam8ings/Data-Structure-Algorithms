class Solution {
    public int maxProduct(int n) {
        // 1. brute store first and first + 1 then use time complexity= O(n) space complexity= O(1)
        //2. better solution is use hashing to store them time complexity= O(1) space complexity= O(n)
        //3. Optimal solution is using mathematical approach time complexity= O(1) space complexity= O(1)

        int first = 0, second = 0;
        while( n!= 0){
            int x = n%10;

            if( x > first){
                second = first;
                first = x;
            }
            else if(x > second){
                second = x;
            } n = n/10;
        }
        return first*second ;
    }
}