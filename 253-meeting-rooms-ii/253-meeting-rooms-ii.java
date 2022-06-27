class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        
        for(int i=1; i<intervals.length; i++)
        {
            if(intervals[i][0] >= pq.peek()) pq.poll();
            pq.add(intervals[i][1]);
        }
        return pq.size();
    }
}