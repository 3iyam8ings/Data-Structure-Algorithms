class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m*n;

        k = k%total;
        int[][] ans = new int[m][n];
        for( int i = 0; i < total ; i++){
            int newidx = ( i + k) % total;
            
            ans[newidx / n ][newidx % n ] = grid[i / n ][i % n ] ;
        }
            List<List<Integer>> result = new ArrayList<>();
            
            for(int[] row : ans){
                List<Integer> list = new ArrayList<>();
                for (int x : row)
                list.add(x);
                result.add(list);
        }
        return result;
    }
}