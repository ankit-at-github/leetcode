class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList());
        
        for(int [] prerequisite : prerequisites) adj.get(prerequisite[0]).add(prerequisite[1]);
        
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++)
        {
            if(!visited[i])
            {
                if(cycleDFS(i, visited, dfsVisited, adj)) return false;
            }
        }
        return true;
    }
    public boolean cycleDFS(int node, boolean[] visited, boolean[] dfsVisited, List<List<Integer>> adj)
    {
        visited[node] = true;
        dfsVisited[node] = true;
        for(int adjacentNode : adj.get(node))
        {
            if(!visited[adjacentNode])
            {
                if(cycleDFS(adjacentNode, visited, dfsVisited, adj)) return true;
            }
            if(visited[adjacentNode] && dfsVisited[adjacentNode]) return true;
        }
        dfsVisited[node] = false;
        return false;
    }
}