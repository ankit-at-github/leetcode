class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for(int i=0; i<n; i++)
        {
            if(colors[i] == -1)
            {
                colors[i] = 0;
                if(!bipartiteDFS(i, graph, colors)) return false;
            }
        }
        return true;
    }
    public boolean bipartiteDFS(int node, int[][] graph, int[] colors)
    {
        for(int adjacentNode : graph[node])
        {
            if(colors[adjacentNode] == -1)
            {
                colors[adjacentNode] = colors[node]==0?1:0;
                if(!bipartiteDFS(adjacentNode, graph, colors)) return false;
            }
            else
            {
                if(colors[adjacentNode] == colors[node]) return false;
            }
        }
        return true;
    }
}