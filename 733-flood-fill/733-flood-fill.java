class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        int oldColor = image[sr][sc];
        
        if(oldColor != color) dfs(image, sr, sc, color, oldColor, visited);
        
        return image;
    }
    public void dfs(int[][] image, int x, int y, int color, int oldColor, boolean[][] visited)
    {
        image[x][y] = color;
        visited[x][y] = true;
        
        //UP
        if(validPath(image, x-1, y, visited, oldColor))
        {
            dfs(image, x-1, y, color, oldColor, visited);
        }
          //Down
        if(validPath(image, x+1, y, visited, oldColor))
        {
            dfs(image, x+1, y, color, oldColor, visited);
        }
          //Left
        if(validPath(image, x, y-1, visited, oldColor))
        {
            dfs(image, x, y-1, color, oldColor, visited);
        }
          //Right
        if(validPath(image, x, y+1, visited, oldColor))
        {
            dfs(image, x, y+1, color, oldColor, visited);
        }
    }
    public boolean validPath(int[][] image, int x, int y, boolean[][] visited, int oldColor)
    {
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || 
           image[x][y] != oldColor || visited[x][y] == true) return false;
        return true;
    }
}