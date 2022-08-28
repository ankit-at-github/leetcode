class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        int[] indegree = new int[n];
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) if(indegree[i] == 1) q.add(i);
        
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            ans = new ArrayList<>();
            for(int i=q.size(); i>0; i--)
            {
                int node = q.poll();
                ans.add(node);
                
                for(int adjacentNode : adj.get(node))
                {
                    indegree[adjacentNode]--;
                    if(indegree[adjacentNode] == 1) q.add(adjacentNode);
                }
            }
        }
        
        
        return ans;
    }
}