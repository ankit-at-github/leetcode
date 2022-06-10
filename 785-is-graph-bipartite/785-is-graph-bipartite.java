class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        
        //Need to check for each node
        for(int i=0; i<graph.length; i++)
        {
            if(color[i] == -1)
            {
                if(!bfs(graph, i, color)) return false;
                
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph, int node, int[] color)
    {
        color[node] = 0;
        
        //Traversing graph
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty())
        {
            int currentNode = q.poll();
            //Getting the adjacent nodes to current node
            for(int adjacentNode : graph[currentNode])
            {
                //checking if adjacent node is marked or not
                if(color[adjacentNode] == 0 || color[adjacentNode] == 1)
                {
                    if(color[adjacentNode] == color[currentNode]) return false;
                }
                else
                {
                    if(color[currentNode] == 0) color[adjacentNode] = 1;
                    else color[adjacentNode] = 0;
                    q.add(adjacentNode);
                }
            }
        }
        return true;
    }
}