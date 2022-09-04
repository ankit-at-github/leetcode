class OrderedStream {
    String[] s;
    int id = 0;
    public OrderedStream(int n) {
        s = new String[n+1];
    }
    
    public List<String> insert(int idKey, String value) {
        s[idKey-1] = value;
        List<String> ans = new ArrayList<>();
        while(s[id] != null)
        {
            ans.add(s[id]);
            id++;
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */