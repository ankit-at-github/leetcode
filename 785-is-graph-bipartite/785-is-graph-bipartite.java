class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList());
        
        for(int i=0; i<n; i++)
        {
            for(int x : graph[i])
                adj.get(i).add(x);
        }
        
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int v=0; v<n; v++)
        {
            if(colors[v]==-1)
            {
                q.add(v);
                colors[v]=0;
                while(!q.isEmpty())
                {
                    for(int i=q.size(); i>0; i--)
                    {
                        int node = q.poll();
                        for(int adjacentNode : adj.get(node))
                        {
                            if(colors[adjacentNode] == -1)
                            {
                                colors[adjacentNode] = colors[node]==1?0:1;
                                q.add(adjacentNode);
                            }
                            else
                            {
                                if(colors[adjacentNode] == colors[node]) return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}