class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<int[]>());
        
        for(int[] time : times)
        {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new int[]{v, w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{k, 0});
        
        int[] signalReceive = new int[n+1];
        Arrays.fill(signalReceive, Integer.MAX_VALUE);
        signalReceive[k] = 0;
        
        while(!pq.isEmpty())
        {
            int node = pq.peek()[0];
            int time = pq.poll()[1];
            for(int[] adjacent : adj.get(node))
            {
                int adjacentNode = adjacent[0];
                int currentTime = adjacent[1];
                
                if(time + currentTime < signalReceive[adjacentNode])
                {
                    signalReceive[adjacentNode] = time + currentTime;
                    pq.add(new int[]{adjacentNode, signalReceive[adjacentNode]});
                }
            }
        }
        
        int maxi = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) maxi = Math.max(maxi, signalReceive[i]);
        
        return maxi==Integer.MAX_VALUE?-1:maxi;
    }
}