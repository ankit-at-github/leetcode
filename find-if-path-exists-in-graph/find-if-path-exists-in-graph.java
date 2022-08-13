class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0 || source == destination) return true;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return bfs(source, destination, adj, visited);
    }
    public boolean bfs(int source, int destination, List<List<Integer>> adj, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;
        
        while(!q.isEmpty())
        {
            int node = q.poll();
            for(int adjacentNode : adj.get(node))
            {
                if(!visited[adjacentNode])
                {
                    if(adjacentNode == destination) return true;
                    visited[adjacentNode] = true;
                    q.add(adjacentNode);
                }
            }
        }
        return false;
    }
}