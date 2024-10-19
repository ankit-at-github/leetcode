class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length == 0) return new int[0];
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m*n];
        int x = 0, y = 0, d = 1;
        int index = 0;
        while(index < m*n){
            if(d == 1){
                while(x > 0 && y < n-1){
                    result[index++] = mat[x][y];
                    x--;
                    y++;
                }
                result[index++] = mat[x][y];
                d = -d;
                if(y == n-1) x++;
                else y++;
            }
            else{
                while(y > 0 && x < m-1){
                    result[index++] = mat[x][y];
                    x++;
                    y--;
                }
                result[index++] = mat[x][y];
                d = -d;
                if(x == m-1) y++;
                else x++;
            }
        }
        return result;
    }
}