class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int mini = Integer.MAX_VALUE;
        int level = 0;
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];
                
                if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 1) continue;
                
                grid[x][y] = 1;
                
                if(x == m-1 && y == n-1){
                    mini = Math.min(mini, level);
                }
                
                //8 directional
                q.add(new int[] {x, y+1});
                q.add(new int[] {x+1, y+1});
                q.add(new int[] {x+1, y});
                q.add(new int[] {x+1, y-1});
                q.add(new int[] {x, y-1});
                q.add(new int[] {x-1, y-1});
                q.add(new int[] {x-1, y});
                q.add(new int[] {x-1, y+1});
            }
            level++;
        }
        return mini==Integer.MAX_VALUE ? -1 : mini+1 ;
    }
}