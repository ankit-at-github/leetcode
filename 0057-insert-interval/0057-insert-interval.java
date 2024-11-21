class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int index = 0;
        //Intervals not overlapping
        while(index < intervals.length && intervals[index][1] < newInterval[0]){
            ans.add(intervals[index]);
            index++;
        }
        //Merge Overlapping Ones
        while(index < intervals.length && newInterval[1] >= intervals[index][0]){
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }
        ans.add(newInterval);
        //3. LeftOvers
        while(index < intervals.length){
            ans.add(intervals[index]);
            index++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}