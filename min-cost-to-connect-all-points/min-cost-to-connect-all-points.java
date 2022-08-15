class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        //find all pair
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int dist = distance(points[i][0], points[j][0], points[i][1], points[j][1]);
                pq.add(new int[]{i , j, dist});
            }
        }
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        for(int i=0; i<n; i++) parent[i] = i;
        
        int cost = 0;
        
        while(!pq.isEmpty())
        {
            int u = pq.peek()[0];
            int v = pq.peek()[1];
            int w = pq.poll()[2];
            
            if(findParent(u, parent) != findParent(v, parent))
            {
                cost+=w;
            }
            union(u, v, rank, parent);
        }
        return cost;
    }
    public int distance(int x1, int x2, int y1, int y2)
    {
        return (Math.abs(x1-x2) + Math.abs(y1-y2));
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