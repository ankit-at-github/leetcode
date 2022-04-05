class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int x : nums)
        {
            if(m.containsKey(x)) m.put(x,m.get(x)+1);
            else m.put(x,1);
        }
        for(Map.Entry<Integer,Integer> entry : m.entrySet()) if(entry.getValue()!=1) return true;
        return false;
    }
}