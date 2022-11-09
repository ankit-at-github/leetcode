class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        List<List<Integer>> mergedInterval = new ArrayList<>();
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int index=1; index<intervals.length; index++)
        {
            if(end < intervals[index][0])
            {
                mergedInterval.add(Arrays.asList(start, end));
                start = intervals[index][0];
            }
            end = Math.max(end, intervals[index][1]);
        }
        
        mergedInterval.add(Arrays.asList(start, end));
        
        int[][] output = new int[mergedInterval.size()][2];
        int index = 0;
        for(List<Integer> mI : mergedInterval)
        {
            output[index][0] = mI.get(0);
            output[index][1] = mI.get(1);
            index++;
        }
        return output;
    }
}