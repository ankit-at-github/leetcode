class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            
            if(end < intervals[i][0]){
                ans.add(new int[]{start, end});
                start = intervals[i][0];
            }
            
            end = Math.max(end, intervals[i][1]);
            
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][2]);
    }
}