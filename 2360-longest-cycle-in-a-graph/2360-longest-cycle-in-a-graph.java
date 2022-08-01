class Solution {
    int maxi = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int i=0; i<n; i++)
        {
            if(edges[i] == -1) continue;
            adj.get(i).add(edges[i]);
        }
        
        boolean[] visited = new boolean[n];
        int[] depth = new int[n];
        Arrays.fill(depth, -1);
        
        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                cycleDFS(i, adj, visited, 1, depth);
            }
        }
        
        return maxi;
    }
    public void cycleDFS(int node, List<List<Integer>> adj, boolean[] visited, int deep, int[] depth)
    {
        visited[node]= true;
        depth[node] = deep;
        for(int adjacentNode : adj.get(node))
        {
            if(!visited[adjacentNode])
            {
                cycleDFS(adjacentNode, adj, visited, deep+1, depth);
            }
            else if(depth[adjacentNode]!=-1)
            {
                maxi = Math.max(maxi, depth[node]-depth[adjacentNode]+1);
            }
        }
        depth[node] = -1;
    }
}