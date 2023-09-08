class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        
        for(int i=1; i<numRows; i++)
        {
            List<Integer> prevRow = ans.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            for(int j=0; j<=i; j++)
            {
                if(j == 0 || j == i) currentRow.add(1);
                else currentRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            ans.add(currentRow);
        }
        return ans;
    }
}