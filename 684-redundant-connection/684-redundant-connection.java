class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] rank = new int[n+1];
        int[] parent = new int[n+1];
        for(int i=0; i<=n; i++) parent[i] = i;
        
        for(int[] edge : edges)
        {
            if(!union(edge[0], edge[1], rank, parent)) return edge;
        }
        return new int[]{};
    }
    public int findParent(int node, int[] parent)
    {
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node], parent);
    }
    public boolean union(int u, int v, int[] rank, int[] parent)
    {
        int rootU = findParent(u, parent);
        int rootV = findParent(v, parent);
        
        if(rootU == rootV) return false;
        
        if(rank[rootU] < rank[rootV])
        {
            parent[rootU] = rootV;
        }
        else if(rank[rootU] > rank[rootV])
        {
            parent[rootV] = rootU;
        }
        else
        {
            parent[rootU] = rootV;
            rank[rootV]++;
        }
        return true;
    }
}