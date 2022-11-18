class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color) return image;
        
        fill(original, sr, sc, color, image);
        
        return image;
    }
    public void fill(int original, int x, int y, int color, int[][] image)
    {
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != original) return;
        
        image[x][y] = color;
        
        //up
        fill(original, x-1, y, color, image);
        //left
        fill(original, x, y-1, color, image);
        //right
        fill(original, x, y+1, color, image);
        //down
        fill(original, x+1, y, color, image);
        
    }
}