class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> finalIntervals = new ArrayList<>();
        int[] start = new int[100001];
        int[] end = new int[100001];
        
        for(int i=0; i<intervals.length; i++)
        {
            start[intervals[i][0]]++;
            end[intervals[i][1]]--;
        }
        
        start[newInterval[0]]++;
        end[newInterval[1]]--;
        
        int count = 0;
        
        List<Integer> current = new ArrayList<>();
        
        for(int i=0; i<100001; i++)
        {
            if(start[i] > 0 && current.size()==0) current.add(i);
            count+=start[i];
            if(count > 0)
            {
                count+=end[i];
                if(count==0)
                {
                    current.add(i);
                    finalIntervals.add(current);
                    current = new ArrayList<>();
                }
            }
        }
        int[][] result = new int[finalIntervals.size()][2];
        int index = 0;
        for(List<Integer> l : finalIntervals)
        {
            result[index][0] = l.get(0);
            result[index][1] = l.get(1);
            index++;
        }
        
        return result;
    }
}