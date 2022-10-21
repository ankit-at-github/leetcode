class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<32; i++)
        {
            //to calculate number of one is each bit of all numbers
            int sum = 0;
            for(int num : nums)
            {
                //getting ith bit of number and calculating sum. shift-operator shifted bit to get last bit use & with 1.
                sum+=(num >> i) & 1;
            }
            //storing 1 at ith location by masking 
            result = result | (sum % 3 << i);
        }
        return result;
    }
}