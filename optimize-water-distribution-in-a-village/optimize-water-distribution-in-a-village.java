class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();
        
        //Adding virtual vertex 0 along with edges
        for(int i=0; i<wells.length; i++) edges.add(new int[]{0, i+1, wells[i]});
        
        //Adding rest of the pipes/edges
        for(int[] pipe : pipes) edges.add(pipe);
        
        Collections.sort(edges, (a,b) -> a[2]-b[2]);
        
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        
        for(int i=1; i<=n; i++) parent[i] = i;
        
        int cost = 0;
        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            if(findParent(u, parent) != findParent(v, parent))
            {
                cost+=w;
                union(u, v, rank, parent);
            }
        }
        return cost;
    }
    public int findParent(int node, int[] parent)
    {
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node], parent);
    }
    public void union(int u, int v, int[] rank, int[] parent)
    {
        int rootU = findParent(u, parent);
        int rootV = findParent(v, parent);
        
        if(rank[rootU] > rank[rootV])
        {
            parent[rootV] = rootU;
        }
        else if(rank[rootU] < rank[rootV])
        {
            parent[rootU] = rootV;
        }
        else
        {
            parent[rootU] = rootV;
            rank[rootV]++;
        }
    }
}