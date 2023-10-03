class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean[] visited = new boolean[v];
        boolean[] dfsVisited = new boolean[v];
        for(int i=0; i<v; i++)
        {
            if(!visited[i])
            {
                if(dfs(i, visited, dfsVisited, graph))
                {
                    //ans.add(i);
                }
                
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<dfsVisited.length; i++) if(!dfsVisited[i]) ans.add(i);
        return ans;
    }
    public boolean dfs(int node, boolean[] visited, boolean[] dfsVisited, int[][] graph)
    {
        visited[node] = true;
        dfsVisited[node] = true;
        
        for(int adjacentNode : graph[node])
        {
            if(!visited[adjacentNode])
            {
                if(dfs(adjacentNode, visited, dfsVisited, graph)) return true;
            }
            else
            {
                if(dfsVisited[adjacentNode]) return true;
            }
        }
        dfsVisited[node] = false;
        return false;
    }
}