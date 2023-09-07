class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<Integer>());
        //Creating Graph
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(isConnected[i][j] == 1)
                {
                    adj.get(i+1).add(j+1);
                    adj.get(j+1).add(i+1);
                }
            }
        }
        boolean[] visited = new boolean[n+1];
        int count = 0;
        for(int i=1; i<=n; i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i, visited, adj);
            }
        }
        return count;
    }
    public void dfs(int start, boolean[] visited, List<List<Integer>> adj)
    {
        visited[start] = true;
        for(int adjacentNode : adj.get(start))
        {
            if(!visited[adjacentNode]) dfs(adjacentNode, visited, adj);
        }
    }
}