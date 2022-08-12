class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(0);
        
        dfs(0, current, ans, graph);
        
        return ans;
    }
    public void dfs(int node, List<Integer> current, List<List<Integer>> ans, int[][] graph)
    {
        for(int adjacentNode : graph[node])
        {
            current.add(adjacentNode);
            dfs(adjacentNode, current, ans, graph);
            current.remove(current.size()-1);
        }
        
        if(node == graph.length-1) ans.add(new ArrayList(current));
    }
}