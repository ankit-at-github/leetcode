class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        
        for(int i=1; i<numRows; i++)
        {
            List<Integer> previous = res.get(i-1);
            List<Integer> current = new ArrayList<>();
            for(int j=0; j<=i; j++)
            {
                if(j == 0 || j==i) current.add(1);
                else
                {
                    current.add(previous.get(j-1) + previous.get(j));
                }
            }
            res.add(current);
        }
        return res;
    }
}