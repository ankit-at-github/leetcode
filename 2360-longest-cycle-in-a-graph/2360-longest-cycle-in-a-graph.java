class Solution {
    int ans = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        
        //to store distance from one node to another
        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        boolean[] dfsVisited = new boolean[n];
        
        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                cycleDFS(i, edges, visited, dfsVisited, distance, 0);
            }
        }
        return ans;
    }
    public void cycleDFS(int node, int[] edges, boolean[] visited, boolean[] dfsVisited, int[] distance, int dist)
    {
        visited[node] = true;
        dfsVisited[node] = true;
        distance[node] = dist;
        
        int adjacentNode = edges[node];
        
        if(adjacentNode != -1)
        {
            if(!visited[adjacentNode])
            {
                cycleDFS(adjacentNode, edges, visited, dfsVisited, distance, dist+1);
            }
            else if(dfsVisited[adjacentNode])
            {
                ans = Math.max(ans, dist - distance[adjacentNode] + 1);   
            }
        }
        dfsVisited[node] = false;
    }
}