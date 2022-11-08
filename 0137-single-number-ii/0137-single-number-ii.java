class Solution {
    public int singleNumber(int[] nums) {
        //optimized approach using bitmasking
        int result = 0 ;
        for(int i=1; i<=32; i++)
        {
            int sum = 0;
            for(int num : nums)
            {
                sum+=(num >> i) & 1;
            }
            result = result | (sum%3 << i);
        }
        return result;
    }
}