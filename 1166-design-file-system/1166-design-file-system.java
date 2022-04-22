class FileSystem {
    Map<String, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        String[] words = path.split("/");
        StringBuilder sb = new StringBuilder();
        int i=1;
        for(; i<words.length-1; i++)
        {
            sb.append("/"+words[i]);
            if(!map.containsKey(sb.toString())) return false;
        }
        sb.append("/"+words[i]);
        
        String key = sb.toString();
        if(map.containsKey(key)) return false;
        map.put(key, value);
        return true;
    }
    
    public int get(String path) {
        if(!map.containsKey(path)) return -1;
        return map.get(path);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */