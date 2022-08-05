class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        int[] rank = new int[n];
        for(int[] edge : edges)
        {
            //checking if two vertices are already connected.
            if(isConnected(edge[0], edge[1], parent)) return false;
            union(edge[0], edge[1], rank, parent);
        }
        return true;
    }
    public int find(int node, int[] parent)
    {
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node], parent);
    }
    public void union(int u, int v, int[] rank, int[] parent)
    {
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        
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
    public boolean isConnected(int u, int v, int[] parent)
    {
        if(find(u, parent) == find(v, parent)) return true;
        return false;
    }
}