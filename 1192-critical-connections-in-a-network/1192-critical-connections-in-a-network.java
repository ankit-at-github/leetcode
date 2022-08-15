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
        int[] discoveryTime = new int[n];
        int[] lowestPossibleTime = new int[n];
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            discoveryTime[i] = -1;
            lowestPossibleTime[i] = -1;
        }
        
        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                dfs(i, 0, discoveryTime, lowestPossibleTime, -1, visited, adj, result);
            }
        }
        return result;
    }
    public void dfs(int node, int timer, int[] discoveryTime, int[] lowestPossibleTime, int parent, boolean[] visited, List<List<Integer>> adj, List<List<Integer>> result)
    {
        visited[node] = true;
        discoveryTime[node] = timer;
        lowestPossibleTime[node] = timer;
        
        for(int adjacentNode : adj.get(node))
        {
            if(adjacentNode == parent)  continue;
            
            if(!visited[adjacentNode])
            {
                dfs(adjacentNode, timer+1, discoveryTime, lowestPossibleTime, node, visited, adj, result);
                //returning from dfs call of this node, checking if its lowestPossibleTime is updated.
                //If yes, it's child had a back-edge
                lowestPossibleTime[node] = Math.min(lowestPossibleTime[node], lowestPossibleTime[adjacentNode]);
                
                //checking if this edge is a bridge
                if(lowestPossibleTime[adjacentNode] > discoveryTime[node])
                    result.add(Arrays.asList(adjacentNode, node));
            }
            else
            {
                //back-edge
                lowestPossibleTime[node] = Math.min(lowestPossibleTime[node], discoveryTime[adjacentNode]);
            }
        }
    }
}