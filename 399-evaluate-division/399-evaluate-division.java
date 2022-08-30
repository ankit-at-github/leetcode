class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adj = new HashMap<>();
        
        //creating graph
        for(int i=0; i<equations.size(); i++)
        {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            
            //u->v
            if(!adj.containsKey(src)) adj.put(src, new HashMap());
            adj.get(src).put(dest, values[i]);
            
            //v->u
            if(!adj.containsKey(dest)) adj.put(dest, new HashMap());
            adj.get(dest).put(src, 1.0/values[i]);
        }
        
        double[] ans = new double[queries.size()];
        for(int i=0; i<queries.size(); i++)
        {
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), adj);
        }
        
        return ans;
    }
    public double dfs(String source, String destination, HashSet<String> visited, Map<String, Map<String, Double>> adj)
    { 
        if(!adj.containsKey(source)) return -1.0;
        
        if(adj.get(source).containsKey(destination)) return adj.get(source).get(destination);
        
        visited.add(source);
        for(Map.Entry<String, Double> adjacent : adj.get(source).entrySet())
        {
            if(!visited.contains(adjacent.getKey()))
            {
                double weight = dfs(adjacent.getKey(), destination, visited, adj);
                
                if(weight != -1.0)
                return weight*adjacent.getValue();
            }
        }
        return -1.0;
    }
}