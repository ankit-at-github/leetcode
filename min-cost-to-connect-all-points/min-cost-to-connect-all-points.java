class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{0, 0});
        
        boolean[] mst = new boolean[points.length];
        
        int[] cost = new int[points.length];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        cost[0] = 0;
        
        while(!pq.isEmpty())
        {
            int currentNode = pq.peek()[0];
            int weight = pq.poll()[1];
            
            mst[currentNode] = true;
            for(int nextNode = 0; nextNode < points.length; nextNode++)
            {
                if(!mst[nextNode])
                {
                    int dist = distance(points[currentNode][0], points[nextNode][0], points[currentNode][1], points[nextNode][1]);
                    if(cost[nextNode] > dist)
                    {
                        cost[nextNode] = dist;
                        pq.add(new int[]{nextNode, dist});
                    }
                }
            }
        }
        int total = 0;
        for(int x : cost) total+=x;
        return total;
    }
    public int distance(int x1, int x2, int y1, int y2)
    {
        return (Math.abs(x1-x2) + Math.abs(y1-y2));
    }
}