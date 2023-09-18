class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ones = new int[m];
        for(int i=0; i<m; i++)
        {
            int count = 0;
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 1) count++;
            }
            ones[i] = count;
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++)
        {
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for(int j=0; j<ones.length; j++)
            {
                if(ones[j] < min)
                {
                    min = ones[j];
                    minIndex = j;
                }
            }
            ans[i] = minIndex;
            ones[minIndex] = Integer.MAX_VALUE;
        }
        return ans;
    }
}