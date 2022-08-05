class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b) -> (a[0]-b[0]));
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        int timeStamp = -1;
        int friends = n;
        for(int[] log : logs)
        {
            if(!isConnected(log[1], log[2], parent))
            {
                timeStamp = log[0];
                friends--;
            }
            if(friends == 1) return timeStamp;
            union(log[1], log[2], rank, parent);
        }
        return -1;
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
        return (find(u, parent) == find(v, parent));
    }
}