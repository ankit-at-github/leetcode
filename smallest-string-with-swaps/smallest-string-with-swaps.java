class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        for(List<Integer> pair : pairs)
        {
            union(pair.get(0), pair.get(1), rank, parent);
        }
        
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            int root = find(i, parent);
            if(!map.containsKey(root)) map.put(root, new PriorityQueue<Character>());
            map.get(root).add(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
        {
            sb.append(map.get(find(i, parent)).poll());
        }
        return sb.toString();
    }
    public int find(int node, int[] parent)
    {
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node], parent);
    }
    public void union(int u, int v, int[] rank, int[] parent)
    {
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        
        if(rank[rootU] > rank[rootV])
        {
            parent[rootV] = rootU;
        }
        else if(rank[rootU] < rank[rootV])
        {
            parent[rootU] = rootV;
        }
        else
        {
            parent[rootU] = rootV;
            rank[rootV]++;
        }
    }
}