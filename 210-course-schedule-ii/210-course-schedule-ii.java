class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<Integer>());
        
        int[] indegree = new int[numCourses];
        
        //creating graph and marking in-degree
        for(int[] pre : prerequisites)
        {
            int u = pre[1];
            int v = pre[0];
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        //adding nodes that has indegree as 0, to start with
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) if(indegree[i] == 0) q.add(i);
        
        ArrayList<Integer> order = new ArrayList<>();
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                int node = q.poll();
                order.add(node);
                numCourses--;
                for(int adjacentNodes : adj.get(node))
                {
                    indegree[adjacentNodes]--;
                    if(indegree[adjacentNodes] == 0) q.add(adjacentNodes);
                }
            }
        }
        
        int[] result = {};
        
        if(numCourses!=0) return result;
        result = new int[order.size()];
        int index = 0;
        for(int x : order) result[index++] = x;
        
        return result;
    }
}