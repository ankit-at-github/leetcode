class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];
        
        //Storing last row values ---- base case
        for(int j=0; j<n; j++) prev[j] = triangle.get(n-1).get(j);
        
        //Reverse DP
        for(int i=n-2; i>=0; i--)
        {
            int[] current = new int[n];
            for(int j=i; j>=0; j--)
            {
                int noStep = triangle.get(i).get(j) + prev[j];
                int oneStep = triangle.get(i).get(j) + prev[j+1];
                
                current[j] = Math.min(noStep, oneStep);
            }
            prev = current;
        }
        return prev[0];
    }
}