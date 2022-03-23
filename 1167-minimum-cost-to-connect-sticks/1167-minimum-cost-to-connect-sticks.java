class Solution {
    public int connectSticks(int[] sticks) {
        if(sticks.length==1) return 0;
        
        Queue<Integer> queue = new PriorityQueue<>();
        
        for(int x : sticks) queue.add(x);
        
        int minSum = 0;
        
        while(queue.size()!=1)
        {
            int x = queue.poll();
            int y = queue.poll();
            int sum = x+y;
            minSum+=sum;
            queue.add(sum);
        }
        
        return minSum;
        
    }
}