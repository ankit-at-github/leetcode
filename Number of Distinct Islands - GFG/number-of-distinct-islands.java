//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m = grid.length;
        int n = grid[0].length;
        Set<String> st = new HashSet<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, i, j, m, n, grid, sb);
                    st.add(sb.toString());
                }
            }
        }
        return st.size();
    }
    public void dfs(int baseX, int baseY, int x, int y, int m, int n, int[][] grid, StringBuilder sb)
    {
        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0) return;
        
        grid[x][y] = 0;
        sb.append((x-baseX) +" "+ (y-baseY));
        
        dfs(baseX, baseY, x-1, y, m, n, grid, sb);
        dfs(baseX, baseY, x+1, y, m, n, grid, sb);
        dfs(baseX, baseY, x, y-1, m, n, grid, sb);
        dfs(baseX, baseY, x, y+1, m, n, grid, sb);
    }
}
