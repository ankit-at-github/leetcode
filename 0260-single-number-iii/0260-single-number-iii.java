class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0)+1);
        int[] ans = new int[2];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() == 1) ans[index++] = entry.getKey();
        }
        return ans;
    }
}