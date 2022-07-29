class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList());
        
        for(List<Integer> connection : connections)
        {
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }
        
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] discoveryTime = new int[n];
        int[] lowestpossibleTime = new int[n];
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<n; i++)
        {
            parent[i] = -1;
            discoveryTime[i] = -1;
            lowestpossibleTime[i] = -1;
        }
        
        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                dfs(i, 0, discoveryTime, lowestpossibleTime, parent, visited, adj, result);
            }
        }
        return result;
    }
    public void dfs(int node, int timer, int[] discoveryTime, int[] lowestpossibleTime, int[] parent, boolean[] visited, List<List<Integer>> adj, List<List<Integer>> result)
    {
        visited[node] = true;
        discoveryTime[node] = timer;
        lowestpossibleTime[node] = timer;
        
        for(int adjacentNode : adj.get(node))
        {
            if(adjacentNode == parent[node]) continue;
            
            if(!visited[adjacentNode])
            {
                parent[adjacentNode] = node;
                dfs(adjacentNode, timer+1, discoveryTime, lowestpossibleTime, parent, visited, adj, result);
                
                //returning from dfs
                //update the lowestTime of parent node to make sure whether child node had a back-edge.
                lowestpossibleTime[node] = Math.min(lowestpossibleTime[node], lowestpossibleTime[adjacentNode]);
                //checking if this edge is a bridge
                if(lowestpossibleTime[adjacentNode] > discoveryTime[node])
                {
                    result.add(Arrays.asList(adjacentNode,node));
                }
            }
            else
            {
                //adjacentNode is visisted and is a back-edge so update lowestpossibleTime
                lowestpossibleTime[node] = Math.min(lowestpossibleTime[node], discoveryTime[adjacentNode]);
            }
        }
        
    }
}