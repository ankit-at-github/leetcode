class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i=0; i<n; i++)
        {
            if(color[i] == -1)
            {
                if(!bfs(graph, i, color)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph, int index, int[] color)
    {
        color[index] = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int connectedNode: graph[node])
            {
                if(color[connectedNode] != -1)
                {
                    if(color[connectedNode] == color[node]) return false;
                }
                else
                {
                    color[connectedNode] = 1-color[node];
                    q.add(connectedNode);
                }
            }
        }
        
        return true;
    }
}