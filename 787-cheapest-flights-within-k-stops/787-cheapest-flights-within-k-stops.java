class Solution {
    int minCost = 0;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Creating graph
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<int[]>());
        
        for(int[] flight : flights)
        {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{src, 0, 0});
        
        int[] dist = new int[n];
        int[] stops = new int[n];
        for(int i=0; i<n; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            stops[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        stops[src] = 0;
        
        while(!pq.isEmpty())
        {
            int node = pq.peek()[0];
            int price = pq.peek()[1];
            int stop = pq.poll()[2];
            
            if(node == dst) return price;
            
            if(stop == k+1) continue;
            
            for(int[] adjacentNode : adj.get(node))
            {
                if(price + adjacentNode[1] < dist[adjacentNode[0]])
                {
                    dist[adjacentNode[0]] = price + adjacentNode[1];
                    pq.add(new int[]{adjacentNode[0], dist[adjacentNode[0]], stop+1});
                    stops[adjacentNode[0]] = stop+1;
                }
                else if(stop < stops[adjacentNode[0]])
                {
                    dist[adjacentNode[0]] = price + adjacentNode[1];
                    pq.add(new int[]{adjacentNode[0], dist[adjacentNode[0]], stop+1});
                }
            }
        }
        return -1;
    }
}