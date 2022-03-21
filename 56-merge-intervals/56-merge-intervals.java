class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        
        for(int i=1; i<intervals.length; i++)
        {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            
            if(prevEnd >= currentStart)
            {
                prevEnd = Math.max(prevEnd, currentEnd);
            }
            else
            {
                current.add(prevStart);
                current.add(prevEnd);
                ans.add(current);
                current = new ArrayList();
                prevStart = currentStart;
                prevEnd = currentEnd;
            }
        }
        
        /* final pair */
        current.add(prevStart);
        current.add(prevEnd);
        ans.add(current);
        
        int[][] output = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++)
        {
            output[i][0] = ans.get(i).get(0);
            output[i][1] = ans.get(i).get(1);
        }
        
        return output;
    }
}