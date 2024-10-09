class Solution {
    Map<Integer, List<Integer>> dictionary;
    Random rand;
    public Solution(int[] nums) {
        dictionary = new HashMap<>();
        rand = new Random();
        for(int i=0; i<nums.length; i++){
            if(!dictionary.containsKey(nums[i])) dictionary.put(nums[i], new ArrayList());
            dictionary.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> location = dictionary.get(target);
        return location.get(rand.nextInt(location.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */