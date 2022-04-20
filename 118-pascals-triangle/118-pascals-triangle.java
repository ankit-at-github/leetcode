class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        
        for(int i=2; i<=numRows; i++)
        {
            List<Integer> prev = ans.get(i-1-1);
            List<Integer> curr = new ArrayList<>();
            for(int j=1; j<=i; j++)
            {
                if(j==1 || j==i) curr.add(1);
                else 
                {
                    curr.add(prev.get(j-1-1)+prev.get(j-1));
                }
            }
            ans.add(curr);
        }
        
        return ans;
        
    }
}