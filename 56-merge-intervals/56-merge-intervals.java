class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int[] start = new int[10001];
        int[] end = new int[10001];
        
        for(int[] interval : intervals)
        {
            start[interval[0]]++;
            end[interval[1]]--;
        }
        
        int count = 0;
        List<Integer> current = new ArrayList<>();
        for(int i=0; i<10001; i++)
        {
            count+=start[i];
            if(count!=0)
            {
                if(current.size() == 0) current.add(i);
                count+=end[i];
                if(count==0)
                {
                    current.add(i);
                    ans.add(current);
                    current = new ArrayList<>();
                }
            }
        }
        
        int[][] result = new int[ans.size()][2];
        
        for(int i=0; i<ans.size(); i++)
        {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }
        
        return result;
        
    }
}