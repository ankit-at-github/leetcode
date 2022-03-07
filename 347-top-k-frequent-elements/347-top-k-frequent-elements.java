class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //Getting frequence of each element
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(nums[i])) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            else map.put(nums[i], 1);
        }
        
        //Storing it in Priority Queue (Heap) in reverse order to get elements with maximum
        //frequency first
        
        PriorityQueue<Map.Entry<Integer, Integer>> pqMax = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            pqMax.add(entry);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(ans.size() < k)
        {
            Map.Entry<Integer,Integer> entry = pqMax.poll();
            ans.add(entry.getKey());
        }
        
        int[] result = new int[ans.size()];
        int index = 0;
        for(int x : ans) result[index++] = x;
        
        return result;
        
        
    }
}