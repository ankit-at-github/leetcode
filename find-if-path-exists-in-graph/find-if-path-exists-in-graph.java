class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n == 0 || source == destination) return true;
        //creating graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        return PathExist(n, source, destination, adj);
        
    }
    public boolean PathExist(int n, int s, int d, List<List<Integer>> adj)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        
        boolean[] visited = new boolean[n];
        visited[s] = true;
        
        while(!q.isEmpty())
        {
            int current = q.poll();
            for(int adjacentNode : adj.get(current))
            {
                if(adjacentNode == d) return true;
                
                if(!visited[adjacentNode])
                {
                    visited[adjacentNode] = true;
                    q.add(adjacentNode);
                }
            }
        }
        return false;
    }
}