class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //1.Creating graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<Integer>());
        
        for(int[] course : prerequisites)
        {
            int u = course[1];
            int v = course[0];
            adj.get(u).add(v);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] dfsVisited = new boolean[numCourses];
        
        Stack<Integer> order = new Stack<>();
        int[] ans = {};
        
        for(int i=0; i<numCourses; i++)
        {
            if(!visited[i])
            {
                if(checkCycleDFS(adj, i, visited, dfsVisited, order)) return ans;
            }
        }
        
        ans = new int[order.size()];
        int index = 0;
        
        while(!order.isEmpty()) ans[index++] = order.pop();
        
        return ans;
    }
    public boolean checkCycleDFS(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, boolean[] dfsVisited, Stack<Integer> order)
    {
        visited[node] = true;
        dfsVisited[node] = true;
        
        for(int adjacentNode : adj.get(node))
        {
            if(!visited[adjacentNode])
            {
                if(checkCycleDFS(adj, adjacentNode, visited, dfsVisited, order)) return true;
            }
            else
            {
                if(visited[adjacentNode] && dfsVisited[adjacentNode]) return true;
            }
        }
        dfsVisited[node] = false;
        order.add(node);
        return false;
    }
}