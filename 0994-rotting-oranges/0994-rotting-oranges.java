class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) freshOranges++;
                else if(grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        
        //No Fresh Oranges at time 0;
        if(freshOranges == 0) return 0;
        
        int time = -1;
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                int[] axis = q.poll();
                int x = axis[0];
                int y = axis[1];
                
                if(validPath(x, y+1, grid)){
                    grid[x][y+1] = 0;
                    freshOranges--;
                    q.add(new int[]{x, y+1});
                }
                if(validPath(x+1, y, grid)){
                    grid[x+1][y] = 0;
                    freshOranges--;
                    q.add(new int[]{x+1, y});
                }
                if(validPath(x, y-1, grid)){
                    grid[x][y-1] = 0;
                    freshOranges--;
                    q.add(new int[]{x, y-1});
                }
                if(validPath(x-1, y, grid)){
                    grid[x-1][y] = 0;
                    freshOranges--;
                    q.add(new int[]{x-1, y});
                }
            }
            time++;
        }
        return freshOranges == 0 ? time : -1;
    }
    public boolean validPath(int x, int y, int[][] grid){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) return false;
        return true;
    }
}