//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[V];
        boolean[] dfsVisited = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(!visited[i])
            {
                if(dfs(i, visited, dfsVisited, adj)) return true;
            }
        }
        return false;
    }
    public boolean dfs(int node, boolean[] visited, boolean[] dfsVisited, ArrayList<ArrayList<Integer>> adj)
    {
        visited[node] = true;
        dfsVisited[node] = true;
        for(int adjacentNode : adj.get(node))
        {
            if(!visited[adjacentNode])
            {
                if(dfs(adjacentNode, visited, dfsVisited, adj)) return true;
                
            }
            else
            {
                if(dfsVisited[adjacentNode]) return true;
            }
        }
        dfsVisited[node] = false;
        return false;
    }
}