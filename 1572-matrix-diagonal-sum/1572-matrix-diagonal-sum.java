class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int primaryY = 0;
        int secondaryY = mat[0].length-1;
        for(int i=0; i<mat.length; i++)
        {
            sum+=mat[i][primaryY]+mat[i][secondaryY];
            primaryY++;
            secondaryY--;
        }
        
        if(mat.length%2!=0) return sum-mat[mat.length/2][mat.length/2];
        
        return sum;
    }
}