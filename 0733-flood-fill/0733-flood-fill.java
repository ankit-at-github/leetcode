class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color) return image;
        int m = image.length;
        int n = image[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        while(!q.isEmpty())
        {
            int[] coordinate = q.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            if(x < 0 || x >= m || y < 0 || y >= n || image[x][y] != original) continue;
            image[x][y] = color;
            q.add(new int[]{x-1, y});
            q.add(new int[]{x, y-1});
            q.add(new int[]{x, y+1});
            q.add(new int[]{x+1, y});
            
        }
        return image;
    }
}