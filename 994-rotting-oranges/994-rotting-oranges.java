class Solution {
    public boolean checkPath(int[][] grid, int x, int y)
    {
        if((x>=0 && x<grid.length) && (y>=0 && y<grid[0].length) && grid[x][y] == 1) return true;
        else return false;
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        int freshOranges = 0;
        
        /*getting location of all rotten oranges in queue,
        and count of all freshOranges*/
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(grid[i][j] == 1) freshOranges++;
                else if(grid[i][j] == 2) queue.add(new Pair(i, j));
            }
        }
        
        if(freshOranges == 0) return 0;
        
        int time = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            time++;
            for(int i=0; i<size; i++)
            {
                Pair<Integer, Integer> p = queue.poll();
                int x = p.getKey();
                int y = p.getValue();
                
                //left
                int newX = x;
                int newY = y-1;
                if(checkPath(grid, newX, newY))
                {
                    freshOranges--;
                    grid[newX][newY] = 2;
                    queue.add(new Pair(newX, newY));
                }
                //right
                newX = x;
                newY = y+1;
                if(checkPath(grid, newX, newY))
                {
                    freshOranges--;
                    grid[newX][newY] = 2;
                    queue.add(new Pair(newX, newY));
                }
                //top
                newX = x-1;
                newY = y;
                if(checkPath(grid, newX, newY))
                {
                    freshOranges--;
                    grid[newX][newY] = 2;
                    queue.add(new Pair(newX, newY));
                }
                //bottom
                newX = x+1;
                newY = y;
                if(checkPath(grid, newX, newY))
                {
                    freshOranges--;
                    grid[newX][newY] = 2;
                    queue.add(new Pair(newX, newY));
                }
            }
        }
        return freshOranges == 0 ? time-1 : -1;
    }
}