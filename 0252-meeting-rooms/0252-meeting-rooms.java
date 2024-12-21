class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] i1, int[] i2){
               return i1[0] - i2[0];
           } 
        });
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }
}