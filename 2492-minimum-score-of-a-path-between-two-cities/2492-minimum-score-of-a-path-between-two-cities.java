class Solution {
    int find(int[] root, int i){
        if(root[i] == i) return i;
        return root[i] = find(root, root[i]);
    }
    public int minScore(int n, int[][] roads) {
        int[] root = new int[n + 1];
        for (int i = 0; i <= n; i++)
            root[i] = i;

         for (int[] r : roads)
            root[find(root, r[0])] = find(root, r[1]);

               int res = 10001;
        for (int[] r : roads)
            if (find(root, r[0]) == find(root, 1))
                res = Math.min(res, r[2]);

                  return res;
        // 1. create adjancency list of graph
        // 2. perform bfs with city 1
        // 3. maintaine visited array
        // 4. for each road update min edge weight 
        // 5. continue until entire system visited
        // 6. return min edge weight
    }
}