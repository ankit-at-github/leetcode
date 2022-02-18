class Solution {
    public int solve(int[][] arr, int x, int y, int m, int n, Map<String, Integer> map)
    {
        if(x >= m || y >= n) return 0;
        if(x == m-1 && y == n-1) return 1;
        
        String key = String.valueOf(x) + "," + String.valueOf(y);
        if(map.containsKey(key)) return map.get(key);
        
        int result = solve(arr, x+1, y, m, n, map) + solve(arr, x, y+1, m, n, map);
        
        map.put(key,result);
        
        return result;
    }
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        Map<String, Integer> map = new HashMap<>();
        
        return solve(arr, 0, 0, m, n, map);
        
    }
}