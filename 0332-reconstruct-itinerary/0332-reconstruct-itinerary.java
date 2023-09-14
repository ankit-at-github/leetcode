class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        //DFS - Read question propoerly, if we use BFS you might reach a destination from where you can't return.
        //Using DFS will ensure that all nodes are visited once
        //Constructing Graph, adjacency list of String and List of String in Sorted Order
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets)
        {   
            if(!graph.containsKey(ticket.get(0))) graph.put(ticket.get(0), new PriorityQueue<String>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> ans = new ArrayList<>();
        dfs("JFK", graph, ans);
        return ans;
    }
    public void dfs(String node, Map<String, PriorityQueue<String>> graph, List<String> ans)
    {
        while(graph.containsKey(node) && !graph.get(node).isEmpty())
        {
            dfs(graph.get(node).poll(), graph, ans);
        }
        ans.add(0, node);
    }
}