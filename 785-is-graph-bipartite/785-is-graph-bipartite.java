class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
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
                        for(int adjacentNode : graph[node])
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