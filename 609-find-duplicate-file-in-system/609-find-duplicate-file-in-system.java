class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, ArrayList<String>> fileDirectory = new HashMap<>();
        for(String path : paths)
        {
            String[] words = path.split(" ");
            String root = words[0]+"/";
            
            for(int i=1; i<words.length; i++)
            {
                int open = words[i].indexOf('(');
                int close = words[i].indexOf(')');
                //fileName
                String fileName = words[i].substring(0, open);
                String key = words[i].substring(open, close+1);
                if(!fileDirectory.containsKey(key)) fileDirectory.put(key, new ArrayList<>());
                fileDirectory.get(key).add(root+fileName);
            }
           
            
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> duplicate : fileDirectory.values())
        {
            if(duplicate.size() > 1) ans.add(new ArrayList(duplicate));
        }
        
        return ans;
    }
}