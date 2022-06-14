class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //this question is nothing but detecting a cycle in directed graph.
        //let's write a code for the same
        
        //first create a graph with all edges given
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        
        for(int[] course : prerequisites)
        {
            int u = course[0];
            int v = course[1];
            adj.get(u).add(v);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++)
        {
            if(!visited[i])
            {
                if(checkCycleDFS(adj, i, visited, dfsVisited)) return false;
            }
        }
        return true;
    }
    public boolean checkCycleDFS(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, boolean[] dfsVisited)
    {
        visited[node] = true;
        dfsVisited[node] = true;
        for(int adjacentNode : adj.get(node))
        {
            if(!visited[adjacentNode])
            {
                if(checkCycleDFS(adj, adjacentNode, visited, dfsVisited)) return true;
            }
            else
            {
                if(visited[adjacentNode] && dfsVisited[adjacentNode]) return true;
            }
        }
        dfsVisited[node] = false;
        return false;
    }
}