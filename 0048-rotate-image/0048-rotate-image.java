class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //1. transpose the matrix
        for(int i = 0; i< n - 1 ; i++){
            for( int j =i + 1; j< n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for( int i = 0 ; i< n ; i++){
            reverse(matrix[i], 0, matrix[i].length - 1);
        }
    }
    
    private void reverse(int[] matrix, int left , int right){
        while(left<right){
            int temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left++;
            right--;
        }
    }
}