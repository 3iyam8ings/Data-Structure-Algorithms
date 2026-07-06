// at first i thought for 2d array and hashtable but then i prefer strign builder to store the info being efficient in terms of time complexxity
/*
1. create SB = rows , 2. insert given string elements to rows 
3. create s and numrows alternative for traversing 
4. loop for typecaste to charArray and append to this variable 
5. check for traversing numRow is 0 then move s if it is -1 then dont move 
6. if goingdown is true then currRow ++ else decrement
7. Create another strongbuilder for result then a loop linked with first stringbuilder 
8. then append the elements to result 
9. again typecaste the result to stringand return it 
4. 
*/
class Solution {
    public String convert(String s, int numRows) {
        if( numRows == 1 || s.length() <= numRows ){ return s;}

        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i=0;i< numRows; i++) {
            rows[i] = new StringBuilder() ;
        }
        int curRow = 0;
        boolean goDown = true;

        for(char ch : s.toCharArray()){
            rows[curRow].append(ch);

           if(curRow == 0){ goDown = true;}
           else if(curRow == numRows - 1){ goDown = false;}

           if(goDown == true){ curRow++;}
           else curRow--;
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows){
            result.append(row);
        }
        return result.toString();
    }
}