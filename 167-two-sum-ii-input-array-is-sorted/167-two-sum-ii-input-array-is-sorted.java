class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0; i<numbers.length; i++)
        {
            if(hmap.containsKey(target-numbers[i]))
            {
                ans[0] = hmap.get(target-numbers[i])+1;
                ans[1] = i+1;
                return ans;
            }
            else hmap.put(numbers[i], i);
        }
        return ans;
    }
}