class Solution {
    public int findPath(int[][] grid, int x, int y, int m, int n, Map<String, Integer> map)
    {
        if(x == m-1 && y == n-1) return grid[x][y];
        
        if(x>=m || y>=n) return Integer.MAX_VALUE;
        
        String key = String.valueOf(x) + "," + String.valueOf(y);
        if(map.containsKey(key)) return map.get(key);
        
        int result = grid[x][y] + Math.min(findPath(grid, x, y+1, m, n, map), findPath(grid, x+1, y, m, n, map));
        
        map.put(key, result);
        
        return result;
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Map<String, Integer> map = new HashMap<>();
        
        return findPath(grid, 0, 0, m, n, map);
    }
}