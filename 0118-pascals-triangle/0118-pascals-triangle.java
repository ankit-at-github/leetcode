class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        for(int i=1; i<numRows; i++)
        {
            List<Integer> prev = ans.get(i-1);
            List<Integer> current = new ArrayList<>();
            for(int j=0; j<=i; j++)
            {
                if(j==0 || j==i) current.add(1);
                else current.add(prev.get(j-1) + prev.get(j));
            }
            ans.add(current);
        }
        return ans;
    }
}