class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] prev = new int[4];
        //Initialization
        prev[0] = Math.min(costs[0][1], costs[0][2]);
        prev[1] = Math.min(costs[0][0], costs[0][2]);
        prev[2] = Math.min(costs[0][0], costs[0][1]);
        prev[3] = Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
        
        for(int house=1; house<n; house++)
        {
            int[] temp = new int[4];
            for(int last=0; last<4; last++)
            {
                temp[last] = Integer.MAX_VALUE;
                for(int color=0; color<3; color++)
                {
                    if(color != last)
                    {
                        int cost = costs[house][color] + prev[color];
                        temp[last] = Math.min(temp[last], cost);
                    }
                }
            }
            prev = temp;
        }
        
        return prev[3];
    }
}