class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList());
        
        for(int[] path : paths)
        {
            adj.get(path[0]).add(path[1]);
            adj.get(path[1]).add(path[0]);
        }
        
        int[] garden = new int[n];
        
        mColoring(adj, garden, 1, n);
        
        return garden;
    }
    public boolean mColoring(List<List<Integer>> adj, int[] garden, int node, int n)
    {
        if(node > n) return true;
        
        for(int flower=1; flower<=4; flower++)
        {
            if(isSafe(adj, garden, node, flower))
            {
                garden[node-1] = flower;
                
                if(mColoring(adj, garden, node+1, n)) return true;
                
                garden[node-1] = 0;
            }
        }
        return false;
    }
    public boolean isSafe(List<List<Integer>> adj, int[] garden, int node, int flower)
    {
        for(int adjacentNode : adj.get(node))
        {
            if(garden[adjacentNode-1] == flower) return false;
        }
        return true;
    }
}