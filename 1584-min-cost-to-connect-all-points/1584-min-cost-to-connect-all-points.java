class Solution {
    public int minCostConnectPoints(int[][] points) {
        int p = points.length;
        int[] cost = new int[p];
        Arrays.fill(cost, Integer.MAX_VALUE);
        //Starting Node cost will be zero.
        cost[0] = 0;
        //To track visited node
        boolean[] mst = new boolean[p];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{0,0});
        while(!pq.isEmpty())
        {
            int currentNode = pq.peek()[0];
            int weight = pq.poll()[1];
            mst[currentNode] = true;
            for(int nextNode=0; nextNode<p; nextNode++)
            {
                if(!mst[nextNode])
                {
                                    int distance = mDistance(points[currentNode][0], points[nextNode][0], points[currentNode][1], points[nextNode][1]);
                if(cost[nextNode] > distance)
                {
                    cost[nextNode] = distance;
                    pq.add(new int[]{nextNode, distance});
                }
                }
            }
        }
        int minCost = 0;
        for(int x : cost) minCost+=x;
        return minCost;
    }
    public int mDistance(int x1, int x2, int y1, int y2)
    {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}