class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        if(words.length == 0) return sb.toString();
        
        for(String word : words)
        {
            for(char c : word.toCharArray())
            {
                indegree.put(c, 0);
                graph.put(c, new HashSet<Character>());
            }
        }
        
        for(int i=0; i<words.length-1; i++)
        {
            String word1 = words[i];
            String word2 = words[i+1];
            
            if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
            
            for(int j=0; j<Math.min(word1.length(), word2.length()); j++)
            {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if(c1 == c2) continue;
                
                //if(path already present no need to mark in-degree again)
                if(!graph.get(c1).contains(c2))
                    indegree.put(c2, indegree.getOrDefault(c2, 0)+1);
                
                graph.get(c1).add(c2);
                break;
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        
        for(Map.Entry<Character, Integer> entry : indegree.entrySet())
            if(entry.getValue() == 0) q.add(entry.getKey());
        
        while(!q.isEmpty())
        {
            char node  = q.poll();
            sb.append(node);
            for(char adjacentNode : graph.get(node))
            {
                indegree.put(adjacentNode, indegree.get(adjacentNode)-1);
                if(indegree.get(adjacentNode) == 0) q.add(adjacentNode);
            }
        }
        if(sb.length()!=indegree.size()) return "";
        return sb.toString();
    }
}