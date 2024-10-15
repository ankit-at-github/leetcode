class Solution {
    public int subarraySum(int[] nums, int k) {
        //Algo:
        //Get Subarray of all size O(N^2)
        //check if sum is equal to K, increment count. O(N)
        //TC: O(N^2)
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int count = 0;
        int sum = 0;
        for(int start=0; start<nums.length; start++){
            sum+=nums[start];
            
            if(sum == k) count++;
            
            if(prefixSum.containsKey(sum-k)){
                count+=prefixSum.get(sum-k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}