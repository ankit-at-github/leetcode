class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0; i<n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int maxi = Integer.MIN_VALUE;
        int s = 0, e = 0;
        while(s < start.length){
            if(start[s] < end[e]){
                count++;
                s++;
            }else{
                count--;
                e++;
            }
            maxi = Math.max(maxi, count);
        }
        return maxi;
    }
}