class Solution {
    public int minimumPushes(String word) {
   //1. freq count for word - using hashing 
   //2. sorting all alphabets - using insertion sort 
   //3. calc. minimum pushes - using floor multiplicatio 

   //1. 
   int[] freq = new int[26];
   for( int i = 0; i < word.length(); i++){
    freq[word.charAt(i) - 'a']++;
   }  

   //2. 
   for( int i = 0; i< 26; i++){
    int j = i;
    while( j > 0 && freq[j] > freq[j - 1] ){
       int temp = freq[j];
       freq[j] = freq[j - 1];
       freq[j - 1] = temp;
       j--;
    }
   }   

   //3. 
   int res = 0;
   for( int i = 0; i < 26 && freq[i] != 0 ; i++){
      res += freq[i] * ((i/8) + 1);
   }
   return res;
    }
}