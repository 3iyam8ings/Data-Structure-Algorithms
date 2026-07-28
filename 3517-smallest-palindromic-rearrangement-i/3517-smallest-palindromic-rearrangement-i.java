class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        
        //1. to check if there any mid char using ternanry operator
        String middleChar = ( n & 1) == 1 ? s.charAt( n/2) + "" : "" ;
        
        //2. creating table to store elements 
        StringBuilder half = new StringBuilder();
        int[] hashTable = new int[26];

        //3. storing first half into hashtable 
        for(int i = 0; i< n/2 ; i++){
            hashTable[s.charAt(i) - 'a']++;
        }

        //4. adding the second half in reversed order to the first half and string in hashtable 
        for( int i =0 ; i< 26 ; i++){
            half.append(((char)(i + 'a') + "").repeat(hashTable[i])) ;
        }

        //5. answer = firsthalf + middle + second half
        return half.toString() + middleChar + half.reverse().toString();
    }
}