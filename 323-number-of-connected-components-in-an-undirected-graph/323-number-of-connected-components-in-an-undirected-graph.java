class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int components = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                components++;
                dfs(i, adj, visited);
            }
        }
        return components;
    }
    public void dfs(int node, List<List<Integer>> adj, boolean[] visited)
    {
        visited[node] = true;
        for(int adjacentNode : adj.get(node))
        {
            if(!visited[adjacentNode]) dfs(adjacentNode, adj, visited);
        }
    }
}