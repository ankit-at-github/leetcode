class Solution {
    List<Integer>[] graph;
    boolean[] visited;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        graph = new ArrayList[n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++)
        {
            graph[i] = new ArrayList<>();
        }
        
        //Creating graph, building adjacency list
        for(List<Integer> pair : pairs)
        {
            int source = pair.get(0);
            int destination = pair.get(1);
            
            //undirected graph
            graph[source].add(destination);
            graph[destination].add(source);
        }
        
        char[] answer = new char[n];
        
        for(int i=0; i<n; i++)
        {
            List<Integer> indices = new ArrayList<>();
            List<Character> letters = new ArrayList<>();
            
            if(!visited[i])
            {
                dfs(i, indices, letters, s);
            }
            
            Collections.sort(indices);
            Collections.sort(letters);
            
            for(int j=0; j<indices.size(); j++)
            {
                answer[indices.get(j)] = letters.get(j);
            }
            
        }
        
        return new String(answer);
        
    }
    public void dfs(int index, List<Integer> indices, List<Character> letters, String s)
    {
        visited[index] = true;
        indices.add(index);
        letters.add(s.charAt(index));
        
        for(int connectedNodes : graph[index])
        {
            if(!visited[connectedNodes]) dfs(connectedNodes, indices, letters, s);
        }
    }
}