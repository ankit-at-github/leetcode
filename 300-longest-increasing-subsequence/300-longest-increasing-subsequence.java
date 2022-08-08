class Solution {
    public int LIS(int[] nums, Integer[] num, int m, int n, int[][] dp)
    {
        for(int i=1; i<m+1; i++)
        {
            for(int j=1; j<n+1; j++)
            {
                if(nums[i-1] == num[j-1])
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }
    public int lengthOfLIS(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int x : nums) st.add(x);
        
        Integer[] num = new Integer[st.size()];
        num = st.toArray(num);
        
        Arrays.sort(num);
        
        int m = nums.length;
        int n = num.length;
        
        int[][] dp = new int[m+1][n+1];
        
        return LIS(nums, num, m, n, dp);
    }
}