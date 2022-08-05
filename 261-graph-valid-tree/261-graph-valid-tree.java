class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList());
        
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int components = 0;
        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                components++;
                if(cycleDFS(i, -1, adj, visited)) return false;
            }
        }
        return components==1?true:false;
    }
    public boolean cycleDFS(int node, int parent, List<List<Integer>> adj, boolean[] visited)
    {
        visited[node] = true;
        for(int adjacentNode : adj.get(node))
        {
            if(!visited[adjacentNode])
            {
                if(cycleDFS(adjacentNode, node, adj, visited)) return true;
            }
            else
            {
                if(adjacentNode!=parent) return true;
            }
        }
        return false;
    }
}