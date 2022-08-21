class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int[] flight : flights) adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        
        int[] cost = new int[n];
        int[] stops = new int[n];
        
        for(int i=0; i<n; i++)
        {
            cost[i] = Integer.MAX_VALUE;
            stops[i] = Integer.MAX_VALUE;
        }
        
        cost[src] = 0;
        stops[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{src, 0, 0});
        
        while(!pq.isEmpty())
        {
            int u = pq.peek()[0];
            int price = pq.peek()[1];
            int stop = pq.poll()[2];
            
            if(dst == u) return price;
            
            if(stop >= k+1) continue;
            
            for(int[] adjacent : adj.get(u))
            {
                if(price + adjacent[1] < cost[adjacent[0]])
                {
                    cost[adjacent[0]] = price + adjacent[1];
                    pq.add(new int[]{adjacent[0], cost[adjacent[0]], stop+1});
                    stops[adjacent[0]] = stop+1;
                }
                else
                {
                    if(stop < stops[adjacent[0]])
                    {
                        cost[adjacent[0]] = price + adjacent[1];
                        pq.add(new int[]{adjacent[0], cost[adjacent[0]], stop+1});
                    }
                }
            }
            
        }
        return -1;
    }
}