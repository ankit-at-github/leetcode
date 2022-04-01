class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 2) return true;
        
        for(int i=0; i<=coordinates.length-3; i++)
        {
            if(Area(coordinates[i], coordinates[i+1], coordinates[i+2]) != 0) return false;
        }
        return true;
    }
    public int Area(int[] a, int[] b, int[] c)
    {
        int x1 = a[0];
        int y1 = a[1];
        int x2 = b[0];
        int y2 = b[1];
        int x3 = c[0];
        int y3 = c[1];
        
        return x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2);
    }
}