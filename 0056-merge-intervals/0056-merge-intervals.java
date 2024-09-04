class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<List<Integer>> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            if(end < intervals[i][0]){
                result.add(Arrays.asList(start, end));
                start = intervals[i][0];   
            }
            end = Math.max(end, intervals[i][1]);
        }
        result.add(Arrays.asList(start, end));
        int length = result.size();
        int[][] ans = new int[length][2];
        for(int i=0; i<length; i++){
                ans[i][0] = result.get(i).get(0);
                ans[i][1] = result.get(i).get(1);
        }
        return ans;
    }
}