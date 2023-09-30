class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++)
        {
            if(color[i] == -1)
            {
                color[i] = 0;
                q.add(i);
                if(!bfs(color, q, graph)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int[] color, Queue<Integer> q, int[][] graph)
    {
        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int adjacentNode : graph[node])
            {
                if(color[adjacentNode] == -1)
                {
                    color[adjacentNode] = 1 - color[node];
                    q.add(adjacentNode);
                }
                else
                {
                    if(color[node] == color[adjacentNode]) return false;
                }
            }
        }
        return true;
    }
}