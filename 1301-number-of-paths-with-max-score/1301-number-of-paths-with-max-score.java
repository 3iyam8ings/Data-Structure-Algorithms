class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        // traverse bot-right to top-left
        // Maintain 2Darray, score and ways 
        //max score among down,right, and diagonal neighbors.
        int MOD = 1_000_000_007;
        int n = board.size();
        int[] score = new int[n + 1];
        int[] ways = new int[n+1];
        Arrays.fill(score, -1);
        for(int r = n-1;r>=0;r--){
            int[] nScore = new int[n+1];
            int[] nWays = new int[n+1];
            Arrays.fill(nScore,-1);
            for(int c = n-1;c>=0;c--){
                char ch = board.get(r).charAt(c);

                if(ch == 'X') continue;
                if(ch == 'S') {
                nScore[c] = 0;
                nWays[c] = 1;
                continue;
            } 
            int best = Math.max(score[c], Math.max(nScore[c+1], score[c+1]));

            if(best == -1) continue;
           
            long cnt = 0;

            if(score[c] == best )
            cnt += ways[c];

            if(nScore[c+1] == best)
            cnt+= nWays[c+1];

            if(score[c+1] == best )
            cnt += ways[c+1];

            int val = ch == 'E' ? 0 : ch - '0';
            nScore[c] = best + val;
            nWays[c] = (int)(cnt % MOD);
           }
           score = nScore;
           ways = nWays;
        }
        if(score[0]==-1)
           return new int[]{0,0};
           return new int[]{score[0], ways[0]};
    }
}