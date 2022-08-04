class Solution {
    public int findCircleNum(int[][] isConnected) {
        //Solving using Disjoin Set
        int n = isConnected.length;
        
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        
        for(int i=1; i<n+1; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(isConnected[i][j] == 1 && j!=i)
                {
                    union(i+1, j+1, rank, parent);
                }
            }
        }
        //Number of Provinces is equal to number of distinct parents
        int provinces = 0;
        
        for(int i=1; i<=n; i++)
        {
            if(i == parent[i]) provinces++;
        }
        
        return provinces;
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
            parent[rootV] = rootU;
            //rank of rootV will increase as parent node of same height are attached.
            rank[rootU]++;
        }
    }
}