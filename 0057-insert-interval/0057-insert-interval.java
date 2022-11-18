class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        
        for(int[] interval : intervals)
        {
            if(newInterval[1] < interval[0])
            {
                ans.add(newInterval);
                newInterval = interval;
            }
            else if(interval[1] < newInterval[0])
            {
                ans.add(interval);
            }
            else
            {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        
        ans.add(newInterval);
        
        return ans.toArray(new int[ans.size()][]);
        
    }
}