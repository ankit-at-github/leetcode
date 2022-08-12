class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> t : tickets)
        {
            if(!adj.containsKey(t.get(0))) adj.put(t.get(0), new PriorityQueue<String>());
            adj.get(t.get(0)).add(t.get(1));
        }
        
        List<String> itinerary = new ArrayList<>();
        
        dfs(adj, "JFK", itinerary);
        
        return itinerary;
    }
    public void dfs(Map<String, PriorityQueue<String>> adj, String node, List<String> itinerary)
    {
        while(adj.containsKey(node) && !adj.get(node).isEmpty())
        {
            String adjacentNode = adj.get(node).poll();
            dfs(adj, adjacentNode, itinerary);
        }
        itinerary.add(0, node);
    }
}