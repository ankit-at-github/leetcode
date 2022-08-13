class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(graph.length == 0) return ans;
        
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(0));
        
        while(!q.isEmpty())
        {
            List<Integer> current = new ArrayList<>(q.poll());
            
            int node = current.get(current.size()-1);
            
            if(node == graph.length-1) ans.add(new ArrayList(current));
            
            for(int adjacentNode : graph[node])
            {
                current.add(adjacentNode);
                q.add(new ArrayList(current));
                current.remove(current.size()-1);
            }
        }
        return ans;
    }
}