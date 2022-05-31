class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=1; i<=numRows; i++)
        {
            List<Integer> current = new ArrayList<>();
            List<Integer> previous = new ArrayList<>();
            if(i>1) previous = ans.get(i-1-1);
            for(int j=0; j<i; j++)
            {
                if(j==0 || j==i-1) current.add(1);
                else
                {
                    current.add(previous.get(j-1) + previous.get(j)); 
                }
            }
            ans.add(current);
        }
        
        return ans;
    }
}