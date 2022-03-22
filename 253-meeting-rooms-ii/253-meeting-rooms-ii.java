class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int rooms = 0;
        Queue<Integer> minTime = new PriorityQueue<>();
        minTime.add(intervals[0][1]);
        rooms++;
        
        for(int i=1; i<intervals.length; i++)
        {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            
            if(currentStart < minTime.peek())
            {
                rooms++;
                minTime.add(currentEnd);
            }
            else
            {
                minTime.poll();
                minTime.add(currentEnd);
            }
        }
        
        return minTime.size();
        
    }
}