class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        
        if(n < 2) return true;
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        int end = intervals[0][1];
        for(int i=1; i<n; i++){
            if(end > intervals[i][0]) return false;
            end = intervals[i][1];
        }
        return true;
    }
}