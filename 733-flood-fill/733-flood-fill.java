class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        
        int oldColor = image[sr][sc];
        
        if(oldColor != color) dfs(image, sr, sc, color, oldColor);
        
        return image;
    }
    public void dfs(int[][] image, int x, int y, int color, int oldColor)
    {
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor) return;
        
        image[x][y] = color;
        
        //Up
        dfs(image, x-1, y, color, oldColor);
        //Down
        dfs(image, x+1, y, color, oldColor);
        //Left
        dfs(image, x, y-1, color, oldColor);
        //Right
        dfs(image, x, y+1, color, oldColor);
    }
}