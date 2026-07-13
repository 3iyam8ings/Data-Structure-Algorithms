class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s ="123456789";
        List<Integer> ans = new ArrayList<>();
        for(int len = 2; len<= s.length();len++){
            for(int strtindex = 0; strtindex<= s.length()-len; strtindex++){
                String temp = s.substring(strtindex, len + strtindex);
                int pos = Integer.parseInt(temp);

                if(pos >= low && pos<=high) {ans.add(pos);}
            }
        }
        return ans;
    }
}