class Solution {
    public int maximumWealth(int[][] accounts) {
        int sum = 0, value = Integer.MIN_VALUE;
        for(int i=0; i<accounts.length; i++)
        {
            for(int j=0; j<accounts[i].length; j++) sum+= accounts[i][j];
            value = Math.max(value,sum);
            sum=0;
        }
        return value;
    }
}