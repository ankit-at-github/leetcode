class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color) return image;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        
        while(!q.isEmpty())
        {
            int[] coordinate = q.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            
            if(validPath(x-1, y, image, original))
            {
                image[x-1][y] = color;
                q.add(new int[]{x-1, y});
            }
            
            if(validPath(x, y-1, image, original))
            {
                image[x][y-1] = color;
                q.add(new int[]{x, y-1});
            }
            
            if(validPath(x, y+1, image, original))
            {
                image[x][y+1] = color;
                q.add(new int[]{x, y+1});
            }
            
            if(validPath(x+1, y, image, original))
            {
                image[x+1][y] = color;
                q.add(new int[]{x+1, y});
            }
            
        }
        return image;
    }
    public boolean validPath(int x, int y, int[][] image, int original)
    {
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != original) return false;
        
        return true;
    }
}