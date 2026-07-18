class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0 ; row<9 ; row++){
            Set<Character> check = new HashSet<>();
            for( int i= 0 ; i< 9 ; i++){
                if(board[row][i] == '.') continue;
                if(check.contains(board[row][i])) return false;

                check.add(board[row][i]);
            }
        }
        for(int col = 0 ; col<9 ; col++){
            Set<Character> check = new HashSet<>();
            for( int i= 0 ; i< 9 ; i++){
                if(board[i][col] == '.') continue;
                if(check.contains(board[i][col])) return false;

                check.add(board[i][col]);
            }
        }
        for( int square = 0; square<9 ; square++){
            Set<Character> check = new HashSet<>();
            for(int i = 0 ; i<3; i++){
                for( int j = 0 ; j<3 ; j++){
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if(board[row][col] == '.') continue;
                    if(check.contains(board[row][col])) return false;

                    check.add(board[row][col]);
                }
            }
        }
        return true;
    }
}