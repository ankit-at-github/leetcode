class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst) return 0;
        
        int[] previous = new int[n];
        int[] current = new int[n];
        
        for(int i=0; i<n; i++)
        {
            previous[i] = Integer.MAX_VALUE;
            current[i] = Integer.MAX_VALUE;
        }
        
        previous[src] = 0;
        
        for(int i=0; i<=k ;i++)
        {
            current[src] = 0;
            for(int[] flight : flights)
            {
                int previous_flight = flight[0];
                int current_flight = flight[1];
                int price = flight[2];
                
                if(previous[previous_flight] < Integer.MAX_VALUE)
                {
                    current[current_flight] = Math.min(current[current_flight], price + previous[previous_flight]);
                }
            }
            previous = current.clone();
        }
        return current[dst] == Integer.MAX_VALUE?-1:current[dst];
    }
}