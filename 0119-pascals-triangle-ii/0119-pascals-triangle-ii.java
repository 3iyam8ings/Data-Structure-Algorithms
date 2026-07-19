class Solution {
    public List<Integer> getRow(int rowIndex) {
        long ans = 1;
        int row = rowIndex + 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for(int col= 1; col< row; col++){
            ans = ans*(row - col);
            ans = ans/col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
}