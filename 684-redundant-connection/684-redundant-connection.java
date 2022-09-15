class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        
        int[] ans = new int[2];
        
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            
            boolean[] visited = new boolean[n+1];
            if(cycleBFS(edge[0], visited, adj))
            {
                ans[0] = edge[0];
                ans[1] = edge[1];
                return ans;
            }
        }
        return new int[]{};
    }
    public boolean cycleBFS(int node, boolean[] visited, List<List<Integer>> adj)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{node, -1});
        visited[node] = true;
        
        while(!q.isEmpty())
        {
            int current = q.peek()[0];
            int parent = q.poll()[1];
            for(int adjacentNode : adj.get(current))
            {
                if(visited[adjacentNode] && adjacentNode != parent) return true;
                if(!visited[adjacentNode])
                {
                    visited[adjacentNode] = true;
                    q.add(new int[]{adjacentNode, current});
                }
            }
        }
        return false;
    }
}