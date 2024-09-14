class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0)+1);
        }
        int majority = (nums.length / 2) + 1;
        for(Map.Entry<Integer, Integer> e : freq.entrySet()){
            if(e.getValue() >= majority) return e.getKey();
        }
        return -1;
    }
}