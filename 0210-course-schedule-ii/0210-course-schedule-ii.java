class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Directed - Cycle detection
        //Kahn's algorithm
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<Integer>());
        
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites)
        {
            int v = pre[0];
            int u = pre[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        List<Integer> order = new ArrayList<>();
        int[] ans = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++)
        {
            if(indegree[i] == 0) q.add(i);
        }
        if(q.isEmpty()) return new int[]{};
        for(int i=0; i<numCourses; i++)
        {
            while(!q.isEmpty())
            {
                int node = q.poll();
                order.add(node);
                for(int adjacentNode : adj.get(node))
                {
                    indegree[adjacentNode]--;
                    if(indegree[adjacentNode] == 0) q.add(adjacentNode);
                }
            }
        }
        if(order.size() == numCourses)
        {
            for(int i=0; i<numCourses; i++) ans[i] = order.get(i);
            return ans;
        }
        return new int[]{};
    }
}