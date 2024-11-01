class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        int startTime = intervals[0][0];
        int endTime = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(endTime < intervals[i][0]){
                result.add(new int[]{startTime, endTime});
                startTime = intervals[i][0];
            }
            endTime = Math.max(endTime, intervals[i][1]);
        }
        result.add(new int[]{startTime, endTime});
        int[][] ans = new int[result.size()][2];
        int index = 0;
        for(int[] interval : result){
            ans[index++] = interval;
        }
        return ans;
    }
}