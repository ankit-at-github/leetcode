class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<ppid.size(); i++)
        {
            if(ppid.get(i)!=0)
            {
                if(!map.containsKey(ppid.get(i))) map.put(ppid.get(i), new ArrayList());
                map.get(ppid.get(i)).add(pid.get(i));
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        
        List<Integer> ans = new ArrayList<>();
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                int k = queue.poll();
                ans.add(k);
                if(map.containsKey(k))
                {
                    for(int n : map.get(k)) queue.add(n);
                }
            }
        }
        
        return ans;
    }
}