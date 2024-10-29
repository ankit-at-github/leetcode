class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> mergedIntervalList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(end >= intervals[i][0]){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                mergedIntervalList.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        mergedIntervalList.add(new int[]{start, end});
        int[][] ans = new int[mergedIntervalList.size()][2];
        int index = 0;
        for(int[] interval : mergedIntervalList){
            ans[index++] = interval;
        }
        return ans;
    }
}