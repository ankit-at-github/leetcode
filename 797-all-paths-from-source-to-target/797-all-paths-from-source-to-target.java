class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        path.add(0);
        dfs(0, graph, path, res);
        
        return res;
    }
    public void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> res)
    {
        if(node == graph.length-1) res.add(new ArrayList(path));
        
        for(int adjacentNode : graph[node])
        {
            path.add(adjacentNode);
            dfs(adjacentNode, graph, path, res);
            path.remove(path.size()-1);
        }
    }
}