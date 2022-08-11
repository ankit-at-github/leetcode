class Solution {
    public int minimumCost(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        
        for(int i=0; i<=n; i++) parent[i] = i;
        
        Arrays.sort(connections, (a,b) -> a[2]-b[2]);
        
        int weight = 0;
        boolean[] mst = new boolean[n+1];
        for(int[] connection : connections)
        {
            int u = connection[0];
            int v = connection[1];
            int w = connection[2];
            
            if(findParent(u, parent) != findParent(v, parent))
            {
                weight+=w;
                mst[u] = true;
                mst[v] = true;
                union(u, v, rank, parent);
            }
        }
        return weight;
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