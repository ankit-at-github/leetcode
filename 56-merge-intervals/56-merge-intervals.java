class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        ArrayList<ArrayList<Integer>> mergedIntervals = new ArrayList<>();
        
        ArrayList<Integer> current = new ArrayList<>();
        current.add(intervals[0][0]);
        
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++)
        {
            if(intervals[i][0] > end)
            {
                current.add(end);
                mergedIntervals.add(current);
                current = new ArrayList<>();
                current.add(intervals[i][0]);
            }
            end = Math.max(end, intervals[i][1]);
        }
        if(current.size() != 0)
        {
            current.add(end);
            mergedIntervals.add(current);
        }
        int[][] ans = new int[mergedIntervals.size()][2];
        int index = 0;
        for(List<Integer> l : mergedIntervals)
        {
            ans[index][0] = l.get(0);
            ans[index][1] = l.get(1);
            index++;
        }
        return ans;
    }
}