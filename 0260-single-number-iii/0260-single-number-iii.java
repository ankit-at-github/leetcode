class Solution {
    public int[] singleNumber(int[] nums) {
        int aXORb = 0;
        for(int num : nums) aXORb^=num;
        
        //getting rightmost set bit
        int rightsetbit = aXORb & -aXORb;
        
        int a = 0;
        for(int num : nums)
        {
            if((num & rightsetbit) != 0) a^=num;
        }
        
        return new int[]{a, aXORb^a};
    }
}