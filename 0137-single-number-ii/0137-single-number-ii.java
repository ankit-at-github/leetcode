class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int x : nums) freq.put(x, freq.getOrDefault(x, 0)+1);
        
        for(Map.Entry<Integer, Integer> entry : freq.entrySet())
            if(entry.getValue() == 1) return entry.getKey();
        return -1;
    }
}