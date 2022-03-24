class Solution {
    public int getFood(char[][] grid) {
        if(grid==null || grid.length==0) return -1;
        int start = 0, end = 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j] == '*')
                {
                    start = i;
                    end = j;
                }
            }
        }
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair(start,end));
        
        int distance = 1;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int k=0; k<size; k++)
            {
                Pair<Integer, Integer> p = queue.poll();
                int x = p.getKey();
                int y = p.getValue();
                
                
                //right
                int newX = x;
                int newY = y+1;
                if(path(grid, newX, newY))
                {
                    if(grid[newX][newY] == '#') return distance;
                    grid[newX][newY] = 'X';
                    queue.add(new Pair(newX, newY));
                }
                
                //left
                newX = x;
                newY = y-1;
                if(path(grid, newX, newY))
                {
                    if(grid[newX][newY] == '#') return distance;
                    grid[newX][newY] = 'X';
                    queue.add(new Pair(newX, newY));
                }
                
                //top
                newX = x-1;
                newY = y;
                if(path(grid, newX, newY))
                {
                    if(grid[newX][newY] == '#') return distance;
                    grid[newX][newY] = 'X';
                    queue.add(new Pair(newX, newY));
                }
                //bottom
                newX = x+1;
                newY = y;
                if(path(grid, newX, newY))
                {
                    if(grid[newX][newY] == '#') return distance;
                    grid[newX][newY] = 'X';
                    queue.add(new Pair(newX, newY));
                }
                
            }
            distance++;
        }
        
        return -1;
        
    }
    public boolean path(char[][] grid, int x, int y)
    {
        if(x<0 || x>=grid.length || y<0 || y>=grid[x].length || grid[x][y]=='X') return false;
        return true;
    }
}