class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length-1;
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        
        for(int i=0; i<=n; i++)
        {
            for(int v : graph[i])
            adj.get(i).add(v);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        current.add(0);
        
        dfs(0, adj, current, ans, n);
        
        return ans;
    }
    public void dfs(int node, List<List<Integer>> adj, List<Integer> current, List<List<Integer>> ans, int n)
    {
        for(int adjacentNode : adj.get(node))
        {
            current.add(adjacentNode);
            dfs(adjacentNode, adj, current, ans, n);
            current.remove(current.size()-1);
        }
        if(node == n) ans.add(new ArrayList(current));
    }
}