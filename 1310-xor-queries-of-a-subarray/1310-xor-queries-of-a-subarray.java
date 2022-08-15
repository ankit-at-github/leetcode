class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        
        for(int i=0; i<q; i++)
        {
            ans[i] = findXOR(arr, queries[i][0], queries[i][1]);
        }
        return ans;
    }
    public int findXOR(int[] arr, int start, int end)
    {
        int xor = 0;
        while(start <= end) xor^=arr[start++];
        return xor;
    }
}