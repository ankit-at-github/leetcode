class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] rank = new int[26];
        int[] parent = new int[26];
        for(int i=0; i<26; i++) parent[i] = i;
        
        for(String equation : equations)
        {
            int u = equation.charAt(0)-'a';
            int v = equation.charAt(3)-'a';
            if(equation.charAt(1) == '=') union(u, v, rank, parent);
        }
        
        for(String equation : equations)
        {
            int u = equation.charAt(0)-'a';
            int v = equation.charAt(3)-'a';
            if(equation.charAt(1) == '!')
            {
                if(findParent(u, parent) == findParent(v, parent)) return false;
            }
        }
        return true;
    }
    public int findParent(int node, int[] parent)
    {
        if(node == parent[node]) return node;
        return parent[node] = findParent(parent[node], parent);
    }
    public void union(int u, int v, int[] rank, int[] parent)
    {
        int rootU = findParent(u, parent);
        int rootV = findParent(v, parent);
        
        if(rank[rootU] < rank[rootV])
        {
            parent[rootU] = rootV;
        }
        else if(rank[rootU] > rank[rootV])
        {
            parent[rootV] = rootU;
        }
        else
        {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}