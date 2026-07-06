class Solution {
    public int calculate(String s) {
        Stack<Integer> box = new Stack<>();
        int ans = 0;
        int cur = 0;
        int val = 1;
        for (char ch : s.toCharArray()) {
            if(Character.isDigit(ch)){
                cur = cur * 10 + ( ch - '0');
            }
            else if(ch == '+'){
                 ans += cur* val;
                 cur = 0;
                 val = 1;
            }
            else if(ch =='-'){
                 ans += cur* val;
                 cur =0;
                 val = -1;
            }
            else if(ch == '('){
                box.push(ans);
                box.push(val);
                ans = 0;
                cur = 0;
                val = 1;
            }
            else if(ch == ')'){
                 ans += cur* val;
                 cur = 0;
                 ans *= box.pop();
                 ans += box.pop();
            }
        } 
            ans += cur* val;
             return ans;
    }
}