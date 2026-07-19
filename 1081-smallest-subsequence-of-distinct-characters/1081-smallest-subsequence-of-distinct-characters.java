class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        for(int i =0; i < s.length(); i++){
            last[s.charAt(i) -'a'] = i;
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(seen[c - 'a']) continue;

            while(ans.length() > 0 && ans.charAt(ans.length() - 1) > c && last[ans.charAt(ans.length()-1) - 'a'] > i) {
                seen[ans.charAt(ans.length() - 1) - 'a'] = false;
                ans.deleteCharAt(ans.length() - 1);
            }
            ans.append(c);
            seen[c -'a'] = true ;
        }
        return ans.toString();
    }
}