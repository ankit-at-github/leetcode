class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
        
        int[] indegree = new int[n+1];
        for(int[] relation : relations)
        {
            adj.get(relation[0]).add(relation[1]);
            indegree[relation[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) if(indegree[i]==0) q.add(i);
        
        int semester = 0;
        while(!q.isEmpty())
        {
            for(int i=q.size(); i>0; i--)
            {
                int course = q.poll();
                n--;
                for(int adjacent : adj.get(course))
                {
                    indegree[adjacent]--;
                    if(indegree[adjacent] == 0)
                    {
                        q.add(adjacent);
                    }
                }
            }
            semester++;
        }
        return n == 0?semester:-1;
    }
}