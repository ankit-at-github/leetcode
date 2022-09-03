class OrderedStream {
    String[] l;
    int id = 0;
    public OrderedStream(int n) {
        l = new String[n+1];
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<>();
        l[idKey-1] = value;
        while(l[id]!= null)
        {
            ans.add(l[id]);
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