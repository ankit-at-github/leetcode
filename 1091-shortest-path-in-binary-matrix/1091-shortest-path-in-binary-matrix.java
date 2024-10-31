class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int level = 0;
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                int[] axis = q.poll();
                int x = axis[0];
                int y = axis[1];
                
                if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 1) continue;
                
                grid[x][y] = 1;
                
                if(x == n-1 && y == n-1){
                    return level+1;
                }
                
                q.add(new int[]{x, y+1});
                q.add(new int[]{x+1, y+1});
                q.add(new int[]{x+1, y});
                q.add(new int[]{x+1, y-1});
                q.add(new int[]{x, y-1});
                q.add(new int[]{x-1, y-1});
                q.add(new int[]{x-1, y});
                q.add(new int[]{x-1, y+1});
            }
            level++;
        }
        return -1;
    }
}