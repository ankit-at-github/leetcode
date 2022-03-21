class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int[] start = new int[10001];
        int[] end = new int[10001];
        
        for(int i=0; i<intervals.length; i++)
        {
            start[intervals[i][0]]++;
            end[intervals[i][1]]--;
        }
        
        int count = 0;
        List<Integer> current = new ArrayList<>();
        for(int i=0; i<10001; i++)
        {
            count+=start[i];
            if(count != 0)
            {
                if(current.size()==0) current.add(i);
                count+=end[i];
                if(count == 0)
                {
                    current.add(i);
                    ans.add(current);
                    current = new ArrayList();
                }
            }
        }
        
        int[][] output = new int[ans.size()][2];
        
        for(int i=0; i<ans.size(); i++)
        {
            output[i][0] = ans.get(i).get(0);
            output[i][1] = ans.get(i).get(1);
        }
        return output;
    }
}