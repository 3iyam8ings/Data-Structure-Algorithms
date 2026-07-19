class Solution {
    public int[] twoSum(int[] numbers, int target) {
       int i = 0;
       int j = numbers.length - 1;
       while(j > i){
        int n1 = numbers[i];
        int n2 = numbers[j];

        if(n1 + n2 == target){
            return new int[]{i + 1, j+ 1};
        }
        else if(n1 + n2 > target){
            j--;
        }
        else if(n1 + n2 < target){
            i++;
        }
       }
       return new int[]{-1, -1};
    }
}