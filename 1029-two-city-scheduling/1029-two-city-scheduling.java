class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        for(int[] cost : costs)
        {
            pq.add(new int[]{cost[1] - cost[0], cost[0], cost[1]});
        }
        int n = pq.size()/2;
        int totalCost = 0;
        while(!pq.isEmpty())
        {
            int[] cost = pq.poll();
            if(n-- > 0) totalCost+=cost[2];
            else totalCost+=cost[1];
        }
        return totalCost;
    }
}