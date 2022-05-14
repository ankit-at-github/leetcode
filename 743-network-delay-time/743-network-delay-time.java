class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Creating a graph using adjacency list for storing edge and weights (pair)
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++)
            adj.add(new ArrayList<int[]>());
        
        //Inserting edges and Weights
        for(int i=0; i<times.length; i++)
        {
            int source = times[i][0];
            int destination = times[i][1];
            int weight = times[i][2];
            adj.get(source).add(new int[]{destination, weight});
        }
        
        int[] visitTime = new int[n+1];
        for(int i=0; i<=n; i++) visitTime[i] = Integer.MAX_VALUE;
        
        return bfs(k, adj, visitTime);
    }
    public int bfs(int k, List<List<int[]>> adj, int[] visitTime)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visitTime[k] = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                int currentNode = q.poll();
                List<int[]> weightedEdges = adj.get(currentNode);
                for(int[] p : weightedEdges)
                {
                    int reachTime = visitTime[currentNode] + p[1];
                    if(reachTime < visitTime[p[0]])
                    {
                        visitTime[p[0]] = reachTime;
                        q.add(p[0]);
                    }
                }
            }
        }
        int maxi = Integer.MIN_VALUE;
        for(int i=1; i<visitTime.length; i++)
        {
            if(visitTime[i] == Integer.MAX_VALUE) return -1;
            maxi = Math.max(maxi, visitTime[i]);
        }
        return maxi;
    }
}