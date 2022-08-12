class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0 && source == destination) return true;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList());
        
        for(int[] edge : edges) adj.get(edge[0]).add(edge[1]);
        
        boolean[] visited = new boolean[n];
        
        if(adj.get(source).isEmpty()) return false;
        
        return dfs(adj, source, destination, -1, visited);
    }
    public boolean dfs(List<List<Integer>> adj, int node, int destination, int parent, boolean[] visited)
    {
        if(adj.get(node).isEmpty() && node != destination) return false;
            
        if(node == destination && !adj.get(node).isEmpty()) return false;
        
        visited[node] = true;
        
        for(int adjacentNode : adj.get(node))
        {
            if(!visited[adjacentNode])
            {
                if(!dfs(adj, adjacentNode, destination, node, visited)) return false;
            }
            else
            {
                if(adjacentNode == parent || adjacentNode == node) return false;
            }
        }
        
        visited[node] = false;
        
        return true;
    }
}