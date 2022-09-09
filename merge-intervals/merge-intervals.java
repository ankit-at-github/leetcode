class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(intervals[0][0]);
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++)
        {
            if(intervals[i][0] > end)
            {
                current.add(end);
                result.add(current);
                current = new ArrayList<>();
                current.add(intervals[i][0]);
            }
            end = Math.max(end, intervals[i][1]);
        }
        current.add(end);
        result.add(current);
        int[][] ans = new int[result.size()][2];
        int index = 0;
        for(List<Integer> r : result)
        {
            ans[index][0] = r.get(0);
            ans[index++][1] = r.get(1);
        }
        return ans;
    }
}