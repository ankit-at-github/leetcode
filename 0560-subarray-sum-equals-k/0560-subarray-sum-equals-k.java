class Solution {
    public int subarraySum(int[] nums, int k) {
        //Algo:
        //Get Subarray of all size O(N^2)
        //check if sum is equal to K, increment count. O(N)
        //TC: O(N^2)
        int count = 0;
        for(int start=0; start<nums.length; start++){
            int sum = 0;
            for(int end=start; end<nums.length; end++){
                sum+=nums[end];
                if(sum == k) count++;
            }
        }
        return count;
    }
}