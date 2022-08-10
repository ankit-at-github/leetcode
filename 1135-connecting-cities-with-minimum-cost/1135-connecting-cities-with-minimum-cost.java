class Solution {
    public int minimumCost(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<int[]>());
        
        for(int[] connection : connections)
        {
            int u = connection[0];
            int v = connection[1];
            int w = connection[2];
            
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        boolean[] mst = new boolean[n+1];
        int[] weight = new int[n+1];
        Arrays.fill(weight, Integer.MAX_VALUE);
        
        //Starting from 1.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{1, 0});
        
        weight[1] = 0;
        
        while(!pq.isEmpty())
        {
            int currentNode = pq.poll()[0];
            mst[currentNode] = true;
            
            for(int[] adjacent : adj.get(currentNode))
            {
                int adjacentNode = adjacent[0];
                int adjacentNodeWeight = adjacent[1];
                
                if(!mst[adjacentNode] && adjacentNodeWeight < weight[adjacentNode])
                {
                    weight[adjacentNode] = adjacentNodeWeight;
                    pq.add(new int[]{adjacentNode, adjacentNodeWeight});
                }
            }
        }
        
        int w = 0;
        for(int i=1; i<weight.length; i++) w+=weight[i];
        return w;
    }
}