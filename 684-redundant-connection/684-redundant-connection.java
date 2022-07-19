class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList());
        
        int[] ans = new int[2];
        
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            boolean[] visited = new boolean[n+1];
            if(cycleDFS(edge[0], -1, visited, adj))
            {
                ans[0] = edge[0];
                ans[1] = edge[1];
                return ans;
            }
        }
        return new int[]{};
    }
    public boolean cycleDFS(int node, int parent, boolean[] visited, List<List<Integer>> adj)
    {
        visited[node] = true;
        for(int adjacentNode : adj.get(node))
        {
            if(visited[adjacentNode] && adjacentNode!=parent) return true;
            if(!visited[adjacentNode])
            {
                if(cycleDFS(adjacentNode, node, visited, adj)) return true;
            }
        }
        return false;
    }
}