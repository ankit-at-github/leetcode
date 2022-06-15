class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        
        //in-degree array
        int[] indegree = new int[n+1];
        
        for(int[] relation : relations)
        {
            int u = relation[0];
            int v = relation[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++)
        {
            if(indegree[i] == 0) q.add(i);
        }
        
        int semester = 0;
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>=1; i--)
            {
                int course = q.poll();
                //A course is taken.
                n--;
                for(int adjacentCourse : adj.get(course))
                {
                    indegree[adjacentCourse]--;
                    if(indegree[adjacentCourse] == 0) q.add(adjacentCourse);
                }
            }
            semester++;
        }
        return (n == 0 ? semester : -1);
    }
}