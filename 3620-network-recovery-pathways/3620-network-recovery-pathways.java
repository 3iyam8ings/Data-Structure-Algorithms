class Solution {
    // 1. TOPO SORT FOR DIRECTED GRAPH USED
        // 2. BINARY SERACH

       // 1. topo sort for min distance calculation ie dijkstra type of thing 
     private boolean check(long mid, List<int[]>[] adj, List<Integer> topo, boolean[] online, long k, int n) {
        long INF = (long)1e18; // initial node gap is infinite denoted by 1e18
        long[] dist= new long[n];
        Arrays.fill(dist,INF);
        dist[0]=0;// source node is 0
        for(int x : topo){
            if(dist[x] == INF) continue;

            if(x != 0 && x != n-1 && !online[x]) continue;
            for(int[] edge: adj[x]){
                int v = edge[0]; // distance 
                int w = edge[1]; //weight of shorter version
                if(w < mid) continue;
                if(v != n-1 && !online[v]) continue;
                // relaxation approach
                dist[v] = Math.min(dist[v], dist[x] + w);
            }
        } return dist[n-1] <=k;
     }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
                int n = online.length;
                List<int[]>[] adj = new ArrayList[n];
                for(int i=0; i<n ; i++)
                    adj[i] = new ArrayList<>();

                    int[] indegree = new int[n];
                    int max = 0;

                    for (int[] e : edges) { 
                        int u = e[0];
                        int v = e[1]; 
                        int w = e[2];

                        adj[u].add(new int[]{v, w}); 
                        indegree[v]++; 
                        max = Math.max(max, w);
                }
                Queue<Integer> q = new LinkedList<>(); 
                for (int i = 0; i < n; i++) { 
                    if (indegree[i] == 0) 
                        q.offer(i); 
                    }
                    List<Integer> topo = new ArrayList<>(); 
                    while (!q.isEmpty()) { 
                        int u = q.poll(); 
                        topo.add(u); 
                        
                        for (int[] edge : adj[u]) { 
                            int v = edge[0]; 
                            indegree[v]--; 
                            if (indegree[v] == 0) q.offer(v);
                             } 
                            }
                        long low = 0, high = max;
                         int ans = -1;

                        while (low <= high) {
                            long mid = low + (high - low) / 2;
            
                        if (check(mid, adj, topo, online, k, n)) {
                            ans = (int) mid;
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
            
        return ans;
    }
}