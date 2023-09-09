class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int m = image.length;
        int n = image[0].length;
        int pixel = image[sr][sc];
        dfs(image, sr, sc, m, n, color, pixel);
        return image;
    }
    public void dfs(int[][] image, int x, int y, int m, int n, int color, int pixel)
    {
        if(x < 0 || y < 0 || x >= m || y >= n || image[x][y] != pixel) return;
        
        image[x][y] = color;
        dfs(image, x+1, y, m, n, color, pixel);
        dfs(image, x, y+1, m, n, color, pixel);
        dfs(image, x, y-1, m, n, color, pixel);
        dfs(image, x-1, y, m, n, color, pixel);
    }
}