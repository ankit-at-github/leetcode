class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        
        for(int i=0; i<graph.length; i++)
        {
            if(color[i] == -1)
            {
                color[i] = 0;
                if(!checkDFS(graph, i, color)) return false;
            }
        }
        return true;
    }
    public boolean checkDFS(int[][] graph, int node, int[] color)
    {
       for(int adjacentNode : graph[node])
       {
           if(color[adjacentNode] == -1)
           {
               if(color[node] == 0) color[adjacentNode] = 1;
               else color[adjacentNode] = 0;
               if(!checkDFS(graph, adjacentNode, color)) return false;
           }
           else
           {
               if(color[adjacentNode] == color[node]) return false;
           }
       }
        return true;
    }
}