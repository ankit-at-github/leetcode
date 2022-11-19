class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        
        int count = 0;
        for(int i=1; i<intervals.length; i++)
        {
            if(pq.peek() > intervals[i][0]) count++;
            else
            {
                pq.poll();
                pq.add(intervals[i][1]);
            }
        }
        return count;
    }
}